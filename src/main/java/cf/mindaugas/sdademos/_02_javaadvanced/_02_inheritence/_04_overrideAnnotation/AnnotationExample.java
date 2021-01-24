package cf.mindaugas.sdademos._02_javaadvanced._02_inheritence._04_overrideAnnotation;

import java.util.Iterator;

public class AnnotationExample {
    public static void main(String[] args) {
        Person p1 = new Person(25, "Jonas");
        System.out.println(p1);
    }
}

// 0. Use override when you change the logic of an inherited method (like toString)
// ... override annotation if not specified does not prevent the method from being called correctly
class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "age: " + this.age + " - " + " name: " + this.name;
    }
}

// 1. When implementing an interface
class PersonIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}

// 2. What benefits does @Overrides annotation provide?
// ... if you change the parents implementation of the method,
// ... you will need to change the implementation of the child
