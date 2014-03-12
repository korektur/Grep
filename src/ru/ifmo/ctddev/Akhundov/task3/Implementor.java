package ru.ifmo.ctddev.Akhundov.task3;

import info.kgeorgiy.java.advanced.implementor.Impler;
import info.kgeorgiy.java.advanced.implementor.ImplerException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Implementor implements Impler {

    private Class<?> classToImplement;
    private FileWriter out;
    private List<Method> methods;
    private Constructor[] constructors;
    private String separator = System.lineSeparator();
    private String tab = "    ";

    public void implement(Class<?> token, File root) throws ImplerException {
        int mod = token.getModifiers();
        if (Modifier.isFinal(mod) || token.isPrimitive()){
            throw new ImplerException();
        }
        try {
            String implName = token.getSimpleName() + "Impl";
            String path = root.getName() + "/"
                    + token.getPackage().getName().replaceAll("\\.", "/");
            File f = new File(path);
            f.mkdirs();
            f = new File(path + "/" + token.getSimpleName() + "Impl.java");
            try (FileWriter out = new FileWriter(f)) {
                this.classToImplement = token;
                this.out = out;
                constructors = classToImplement.getConstructors();
                boolean hasDefaultConstr = false;
                /*for(Constructor constructor : constructors) {
                    if (constructor.getExceptionTypes().length == 0){
                        hasDefaultConstr = true;
                    }
                }
                if (!hasDefaultConstr) {
                    throw new ImplerException();
                }*/
                methods = getAllMethods(classToImplement);
                writeClass();
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void writeClass() throws IOException {
        out.append("package " + classToImplement.getPackage().getName() + ";" + separator);
        out.append("public class " + classToImplement.getSimpleName() + "Impl");
        if (classToImplement.isInterface()) {
            out.append(" implements ");
        } else {
            out.append(" extends ");
        }
        out.append(classToImplement.getCanonicalName() + " {" + separator);
        for (Constructor constructor : constructors) {
            writeConstructors(constructor);
        }
        for (Method method : methods) {
            writeMethod(method);
        }
        out.append("}");
    }

    public void writeConstructors(Constructor constructor) throws IOException {
        if (Modifier.isTransient(constructor.getModifiers())) {
            return;
        }
        int modifiers = constructor.getModifiers();
        out.append(tab + Modifier.toString(modifiers));
        out.append(" " + classToImplement.getSimpleName() + "Impl");
        writeArgs(constructor.getParameterTypes());
        writeExceptions(constructor.getExceptionTypes());
        out.append(" {" + separator);
        out.append(tab + tab + "super(");
        int argsNum = constructor.getParameterTypes().length;
        for (int i = 0; i < argsNum; ++i) {
            out.append("arg" + i);
            if (i < argsNum - 1) {
                out.append(", ");
            }
        }
        out.append(");" + separator);
        out.append(tab + "}" + separator);
    }


    public void writeMethod(Method method) throws IOException {
        int modifiers = method.getModifiers();
        if (Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || Modifier.isPrivate(modifiers)
                || Modifier.isTransient(modifiers) || !Modifier.isAbstract(modifiers)) {
            return;
        }
        modifiers ^= Modifier.ABSTRACT;
        out.append(separator);
        out.append(tab + "@Override" + separator);
        out.append(tab);
        Class<?>[] args = method.getParameterTypes();
        out.append(Modifier.toString(modifiers));
        Class<?> returnType = method.getReturnType();
        out.append(" " + returnType.getCanonicalName());
        out.append(" " + method.getName());
        writeArgs(args);
        writeExceptions(method.getExceptionTypes());
        out.append("{" + separator);
        out.append(tab + tab + "return ");
        if (returnType.isPrimitive()) {
            if ("boolean".equals(returnType.getCanonicalName())) {
                out.append("true");
            } else if ("char".equals(returnType.getCanonicalName())) {
                out.append("\'1\'");
            } else if (!"void".equals(returnType.getCanonicalName())) {
                out.append("1");
            }
        } else {
            out.append("null");
        }
        out.append(";" + separator);
        out.append(tab + "}" + separator);

    }

    private void writeArgs(Class<?>[] args) throws IOException {
        out.append("(");
        for (int i = 0; i < args.length; ++i) {
            int mod = args[i].getModifiers();
            Modifier.methodModifiers();

            out.append(args[i].getCanonicalName() + " arg" + i);
            if (i < args.length - 1) {
                out.append(", ");
            }
        }
        out.append(")");
    }

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
