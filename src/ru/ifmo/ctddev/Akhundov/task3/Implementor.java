package ru.ifmo.ctddev.Akhundov.task3;

import info.kgeorgiy.java.advanced.implementor.Impler;
import info.kgeorgiy.java.advanced.implementor.ImplerException;
import info.kgeorgiy.java.advanced.implementor.JarImpler;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.jar.Attributes;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

/**
 * @author Ruslan Akhundov
 *         This class writes a .java file with an implementation of another class, and then compiles it and make a jar
 *         It takes an interface or class and writes a java code of it's implementation(all methods returns default values,
 *         and constructors call super). Then it compiles writen code to .class file, and then makes a jar from it.
 */
public class Implementor implements Impler, JarImpler {

    /**
     * Class for which we want to generate implementation
     *
     * @see java.lang.Class
     */
    private Class<?> classToImplement;

    /**
     * out stream for writing .java files with Implementation.
     *
     * @see java.io.FileWriter
     */
    private FileWriter out;

    /**
     * System line SEPARATOR char sequence.
     */
    private final String SEPARATOR = System.lineSeparator();

    /**
     * Tab char sequence.
     */
    private final String TAB = "    ";


    /**
     * Starts Implementor with defined arguments.
     *
     * @param args arg[0] - class or interface to implement, arg[1] - path to place where jar file must be placed.
     */
    public static void main(String[] args) {
        if (args.length != 2 && args.length != 3) {
            System.out.println("wrong args");
            return;
        }
        try {
            String name, filename;
            if (args.length == 3) {
                if (!"-jar".equals(args[0])) {
                    System.out.println("wrong flag");
                    return;
                }

                name = args[1];
                filename = args[2].substring(0, args[2].indexOf(".jar"));
            } else {
                name = args[0];
                filename = args[1];
            }
            File root = new File(filename);
            Class<?> token = Class.forName(name);
            Implementor implementor = new Implementor();
            if (args.length == 3) {
                implementor.implementJar(token, new File(args[2]));
            } else {
                implementor.implement(token, root);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (ImplerException e) {
            System.out.println("An error occured");
        }
    }

    /**
     * Takes class and root and make an implementation of class and writes it to the root.
     *
     * @param token type token to create implementation for.
     * @param root  root directory.
     * @throws ImplerException When impossible to create Implementation for token.
     * @see java.lang.Class
     * @see java.io.File
     */
    public void implement(Class<?> token, File root) throws ImplerException {
        int mod = token.getModifiers();
        if (Modifier.isFinal(mod) || token.isPrimitive()) {
            throw new ImplerException();
        }
        try {
            String path = root.getName() + "/"
                    + token.getPackage().getName().replaceAll("\\.", "/");
            File f = new File(path);
            f.mkdirs();
            f = new File(path + "/" + token.getSimpleName() + "Impl.java");
            try (FileWriter out = new FileWriter(f)) {
                this.classToImplement = token;
                this.out = out;

                writeClass();
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Compiles file. Compiled file will be placed to the default directory.
     *
     * @param path file which you want to compile
     * @throws IOException in case of something bad happened when we were trying to make a jar
     * @see java.io.File
     */
    private static void compileFile(String path) throws IOException {
        File f = new File(path);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        File[] files = {f};
        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
        fileManager.close();
    }

    /**
     * Makes jar from compiled class file with our implementation.
     *
     * @param classPath path to compiled file with implementation.
     * @param jarPath   path to place where jar will be placed
     * @throws IOException in case of something bad happened when we were trying to make a jar
     */
    private static void makeJar(String jarPath, String classPath) throws IOException {
        File jarFile = new File(jarPath);
        File parent = jarFile.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        jarFile.createNewFile();
        String newClassPath = classPath.substring(classPath.indexOf("tmp/") + 4);
        FileOutputStream fout = new FileOutputStream(jarFile);
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        //manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, newClassPath);
        JarOutputStream jarOut = new JarOutputStream(fout, manifest);
        jarOut.putNextEntry(new ZipEntry(newClassPath));
        FileInputStream fit = new FileInputStream(classPath);
        BufferedInputStream bis = new BufferedInputStream(fit);
        byte[] buff = new byte[10000];
        int bytesRead;
        while ((bytesRead = bis.read(buff)) != -1) {
            jarOut.write(buff, 0, bytesRead);
        }
        jarOut.closeEntry();
        jarOut.close();
        fout.close();
    }

    /**
     * Implements class and then make jar with its implementation.
     *
     * @param token type token to create implementation for.
     * @param jar   file path where we need to write our jar file
     * @throws ImplerException in case we cant implement this class.
     * @see java.lang.Class
     * @see java.io.File
     */
    public void implementJar(Class<?> token, File jar) throws ImplerException {
        try {
            String fileAbsPath = "tmp/";
            fileAbsPath += token.getPackage().getName().replaceAll("\\.", "/");
            fileAbsPath += (token.getPackage().getName().isEmpty()) ? "" : "/";
            (new File(fileAbsPath)).mkdirs();
            fileAbsPath += token.getSimpleName() + "Impl.java";
            this.out = new FileWriter(fileAbsPath, true);
            this.classToImplement = token;
            writeClass();
            out.close();
            compileFile(fileAbsPath);
            String classAbsPath = fileAbsPath.substring(0, fileAbsPath.indexOf(".java")) + ".class";
            makeJar(jar.getPath(), classAbsPath);
            System.gc();
            recDelete(new File("tmp/"));
        } catch (IOException e) {
            System.out.println("Error occurred while working with files");
        }
    }

    /**
     * Deletes directory and all files in it.
     *
     * @param file path to directory or file to delete.
     */
    private void recDelete(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    recDelete(f);
                }
            }
        }
        file.delete();
    }

    /**
     * Writes a java code of the given class or interface.
     *
     * @throws IOException                                             in case of something bad happened when we were writing in file.
     * @throws info.kgeorgiy.java.advanced.implementor.ImplerException if cannot implement given class.
     * @see info.kgeorgiy.java.advanced.implementor.ImplerException
     */
    private void writeClass() throws IOException, ImplerException {
        Constructor[] constructors = classToImplement.getDeclaredConstructors();
        boolean allConstructorArePrivate = true;
        for (Constructor constructor : constructors) {
            allConstructorArePrivate = Modifier.isPrivate(constructor.getModifiers());
            if (!allConstructorArePrivate) {
                break;
            }
        }
        if (allConstructorArePrivate && !classToImplement.isInterface()) {
            throw new ImplerException("all constructors are private");
        }
        List<Method> methods = getAllMethods(classToImplement);
        out.append("package ").append(classToImplement.getPackage().getName()).append(";").append(SEPARATOR);
        out.append(SEPARATOR);
        out.append("public class ").append(classToImplement.getSimpleName()).append("Impl");
        if (classToImplement.isInterface()) {
            out.append(" implements ");
        } else {
            out.append(" extends ");
        }
        out.append(classToImplement.getCanonicalName()).append(" {").append(SEPARATOR);
        for (Constructor constructor : constructors) {
            writeConstructors(constructor);
        }
        for (Method method : methods) {
            writeMethod(method);
        }
        out.append("}");
    }

    /**
     * Writes java code of the given constructor in our implementation.
     * Always calls super.
     *
     * @param constructor constructor to implement
     * @throws IOException in case of something bad happened when we were writing in file
     * @see java.lang.reflect.Constructor
     */
    private void writeConstructors(Constructor constructor) throws IOException {
        int modifiers = constructor.getModifiers();
        if (Modifier.isPrivate(modifiers)) {
            return;
        }
        if (Modifier.isTransient(modifiers)) {
            modifiers ^= Modifier.TRANSIENT;
        }
        out.append(TAB).append(Modifier.toString(modifiers));
        out.append(" ").append(classToImplement.getSimpleName()).append("Impl");
        writeArgs(constructor.getParameterTypes());
        writeExceptions(constructor.getExceptionTypes());
        out.append(" {").append(SEPARATOR);
        out.append(TAB).append(TAB).append("super(");
        int argsNum = constructor.getParameterTypes().length;
        for (int i = 0; i < argsNum; ++i) {
            out.append("arg").append(Integer.toString(i));
            if (i < argsNum - 1) {
                out.append(", ");
            }
        }
        out.append(");").append(SEPARATOR);
        out.append(TAB).append("}").append(SEPARATOR);
    }


    /**
     * Writes java code of the given method.
     * Always returns default value.
     * Doesn't overrides final, native, private or non Abstract methods.
     * Also deletes transient modifier
     *
     * @param method given method to implement
     * @throws IOException in case of something bad happened when we were writing in file
     * @see java.lang.reflect.Method
     */
    private void writeMethod(Method method) throws IOException {
        int modifiers = method.getModifiers();
        if (Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || Modifier.isPrivate(modifiers)
                || !Modifier.isAbstract(modifiers)) {
            return;
        }
        modifiers ^= Modifier.ABSTRACT;
        if (Modifier.isTransient(modifiers)) {
            modifiers ^= Modifier.TRANSIENT;
        }
        out.append(SEPARATOR);
        out.append(TAB).append("@Override").append(SEPARATOR).append(TAB);
        Class<?>[] args = method.getParameterTypes();
        out.append(Modifier.toString(modifiers));
        Class<?> returnType = method.getReturnType();
        out.append(" ").append(returnType.getCanonicalName());
        out.append(" ").append(method.getName());
        writeArgs(args);
        writeExceptions(method.getExceptionTypes());
        out.append("{").append(SEPARATOR);
        out.append(TAB).append(TAB).append("return ");
        if (returnType.isPrimitive()) {
            if ("boolean".equals(returnType.getCanonicalName())) {
                out.append("true");
            } else if ("char".equals(returnType.getCanonicalName())) {
                out.append("'1'");
            } else if (!"void".equals(returnType.getCanonicalName())) {
                out.append("1");
            }
        } else {
            out.append("null");
        }
        out.append(";").append(SEPARATOR);
        out.append(TAB).append("}").append(SEPARATOR);
    }

    /**
     * Writes all arguments and their types for method/constructor declaration
     * for example: "(String arg0, int arg1)"
     *
     * @param args arguments to write.
     * @throws IOException in case of something bad happened when we were writing in file
     * @see java.lang.Class
     */
    private void writeArgs(Class<?>[] args) throws IOException {
        out.append("(");
        for (int i = 0; i < args.length; ++i) {
            Modifier.methodModifiers();
            out.append(args[i].getCanonicalName()).append(" arg").append(Integer.toString(i));
            if (i < args.length - 1) {
                out.append(", ");
            }
        }
        out.append(")");
    }

    /**
     * Writes all exceptions that method could throw(if they exists).
     *
     * @param exceptions array of exceptions which method could throw
     * @throws IOException in case of something bad happened when we were writing in file
     * @see java.lang.Exception
     * @see java.lang.Class
     */
    private void writeExceptions(Class<?>[] exceptions) throws IOException {
        if (exceptions.length == 0) {
            return;
        }
        out.append(" throws ");
        for (int i = 0; i < exceptions.length; ++i) {
            out.append(exceptions[i].getCanonicalName());
            if (i < exceptions.length - 1) {
                out.append(", ");
            }
        }
    }

    /**
     * Checks if two method are equal.
     * Methods are equal when they have the same names, returnTypes, and input arguments.
     *
     * @param a First method to comppare.
     * @param b Second method to compare.
     * @return true if methods are equals, false otherwise.
     * @see java.lang.reflect.Method
     * @see java.lang.Class
     */
    private boolean compareMethods(Method a, Method b) {
        if (a.getName().equals(b.getName())) {
            if (a.getReturnType().equals(b.getReturnType())) {
                Class<?>[] argsA = a.getParameterTypes();
                Class<?>[] argsB = b.getParameterTypes();
                if (argsA.length == argsB.length) {
                    for (int i = 0; i < argsA.length; ++i) {
                        if (!argsA[i].getCanonicalName().equals(argsB[i].getCanonicalName())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets all methods which we need to Override in our class implementation.
     * Go through all the interface and classes in inheritance tree and finds all methods that
     * we must to implement.
     *
     * @param clazz class to implement
     * @return List of method to override
     * @see java.lang.Class
     */
    private List<Method> getAllMethods(Class<?> clazz) {
        if (clazz == null) {
            return new ArrayList<>();
        }
        List<Method> methodsToOverride = new ArrayList<>();
        List<Method> methods = new ArrayList<>();
        methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> interf : interfaces) {
            methods.addAll(getAllMethods(interf));
        }
        Class<?> superClass = clazz.getSuperclass();
        methods.addAll(getAllMethods(superClass));
        for (Method method : methods) {
            boolean fl = true;
            for (int i = 0; i < methodsToOverride.size(); ++i) {
                Method m = methodsToOverride.get(i);
                if (compareMethods(m, method)) {
                    int m1 = m.getModifiers();
                    int m2 = method.getModifiers();
                    if (Modifier.isAbstract(m1) && !Modifier.isAbstract(m2)) {
                        methodsToOverride.remove(i);
                        methodsToOverride.add(method);
                    }
                    fl = false;
                }
            }
            if (fl) {
                methodsToOverride.add(method);
            }
        }
        return methodsToOverride;
    }
}
