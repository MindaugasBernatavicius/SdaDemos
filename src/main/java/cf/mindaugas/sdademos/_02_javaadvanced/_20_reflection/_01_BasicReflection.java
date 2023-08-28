package cf.mindaugas.sdademos._02_javaadvanced._20_reflection;

import java.util.Arrays;

public class _01_BasicReflection {
    private static void _01_obtainInstanceOfClass() throws ClassNotFoundException {
        // System.out.println("".getClass());
        // System.out.println("".getClass().getClass());
        // System.out.println(String.class);.

        // obtaining a named reference
        // var stringClass = String.class;
        // Class<?> stringClass = String.class;
        // Class<? extends String> stringClass = String.class;

        // 3rd... way, very common - just have a name saved somewhere and initialize using Class static method
        Class<?> stringClass = Class.forName("java.lang.String"); // more fragile, can throw many exceptions, but more powerfull
    }

    public static void _02_getSuperclassAndInterfaces() {
        class Person {}
        class Teacher extends Person implements Comparable<Teacher> {
            @Override
            public int compareTo(Teacher o) {
                return 0;
            }
        }

        var superclassOfTeacher = Teacher.class.getSuperclass();
        System.out.println(superclassOfTeacher);
        System.out.println(superclassOfTeacher.getSuperclass());
        System.out.println(superclassOfTeacher.getSuperclass().getSuperclass());

        System.out.println(Arrays.toString(Teacher.class.getInterfaces()));
        System.out.println(Arrays.toString("".getClass().getInterfaces()));
        System.out.println(Arrays.toString(Person.class.getInterfaces()));
    }

    public static void _02_getSuperclassAndInterfaces(Class<?> clazz) {
        while (clazz.getSuperclass() != null) {
            System.out.println(clazz.getSuperclass());
            clazz = clazz.getSuperclass();
        }
    }

    public static void _03_getFields() throws NoSuchFieldException {
        class Person {
            private int age;
            public String name = "A";
        }

        // System.out.println(Person.class.getField("age"));
        // System.out.println(Person.class.getField("name"));

        // System.out.println(Person.class.getDeclaredField("age"));
        System.out.println(Arrays.toString(Person.class.getDeclaredFields()));
    }

    public static void _04_getMethods(){
        // getting methods

        // getting constructors
    }
    public static void _05_readModifiers(){
        // modifiers are kept ina bitfield, we might need to use masking to get know if it is private, static and so on.
        // 0x0000001 - this is error prone
        // so there is a method called Modifier.isPublic(Person.class.getField("").getModifiers())
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // _01_obtainInstanceOfClass();
        // _02_getSuperclassAndInterfaces();
        _03_getFields();
    }

}
