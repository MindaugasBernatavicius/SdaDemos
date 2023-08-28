package cf.mindaugas.sdademos._02_javaadvanced._20_reflection;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Modifier;

public class _02_PlayingAroundWithComplexCase_NOT_COMPLETE {
    public static void main(String[] args) {
        String packageName = "cf.mindaugas.sdademos._02_javaadvanced._25_completableFuture"; // Replace with your package name
        String methodName = "myMethod"; // Replace with your method name
        // Class<?> returnType = String.class; // Replace with your expected return type
        Class<?> returnType = void.class;

        Set<Class<?>> classes = getClassesInPackage(packageName);
        List<Method> methodsWithReturnType = new ArrayList<>();

        // Iterate over the classes and check if they have the specified method with the correct return type
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getReturnType().equals(returnType)) {
                    methodsWithReturnType.add(method);
                }
            }
        }

        // Print the methods with the specified return type
        for (Method method : methodsWithReturnType) {
            System.out.println(method.getDeclaringClass().getName() + " - " + method.getName());
        }
    }

    // Helper method to get all the classes within a package
    private static Set<Class<?>> getClassesInPackage(String packageName) {
        Set<Class<?>> classes = new HashSet<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            java.net.URL resource = classLoader.getResource(path);
            if (resource != null) {
                String filePath = resource.getFile();
                File directory = new File(filePath);
                if (directory.exists()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile() && file.getName().endsWith(".class")) {
                                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                                Class<?> clazz = Class.forName(className);
                                if (!Modifier.isAbstract(clazz.getModifiers())) {
                                    classes.add(clazz);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }
}