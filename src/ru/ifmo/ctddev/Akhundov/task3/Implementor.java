package ru.ifmo.ctddev.Akhundov.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Implementor {

    private final Class<?> classToImplement;
    private final FileWriter out;
    private final Method[] methods;
    private final Constructor[] constructors;
    private final String separator = System.lineSeparator();
    private final String tab = "    ";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Wrong Arguments");
            return;
        }
        String classPath = args[0];
        try {
            Class<?> clazz = Class.forName(classPath);
            String implName = clazz.getSimpleName() + "Impl";
            File f = new File("src/" + implName + ".java");
            try (FileWriter out = new FileWriter(f)) {
                Implementor implementor = new Implementor(clazz, out);
                implementor.writeClass();
                out.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public Implementor(Class<?> classToImplement, FileWriter out) {
        this.classToImplement = classToImplement;
        this.out = out;
        methods = classToImplement.getMethods();
        constructors = classToImplement.getConstructors();

    }

    public void writeClass() throws IOException {
        out.append("public class " + classToImplement.getSimpleName() + "Impl");
        if (classToImplement.isInterface()) {
            out.append(" implements ");
        } else {
            out.append(" extends ");
        }
        out.append(classToImplement.getCanonicalName() + " {" + separator);
        for (Method method : methods) {
            writeMethod(method);
        }
        for (Constructor constructor : constructors) {
            writeConstructors(constructor);
        }
        out.append("}");
    }

    public void writeConstructors(Constructor constructor) throws IOException{
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
        }
        out.append(");" + separator);
        out.append(tab + "}" + separator);
    }


    public void writeMethod(Method method) throws IOException {
        int modifiers = method.getModifiers();
        if (Modifier.isFinal(modifiers) || Modifier.isNative(modifiers) || Modifier.isPrivate(modifiers)
                || !Modifier.isAbstract(modifiers)){
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
            } else {
                out.append("1");
            }
        } else {
            out.append("null");
        }
        out.append(";" + separator);
        out.append(tab + "}" + separator);

    }

    private void writeArgs(Class<?>[] args) throws IOException{
        out.append("(");
        for(int i = 0; i < args.length; ++i){
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
        for(int i = 0; i < exceptions.length; ++i) {
            out.append(exceptions[i].getCanonicalName());
            if (i < exceptions.length - 1) {
                out.append(", ");
            }
        }
    }

}
