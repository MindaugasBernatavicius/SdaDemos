package cf.mindaugas.sdademos._02_javaadvanced._02_inheritence._02_memberhidding;

public class OverridingFields {
    public static void main(String[] args) {
    // Employee e = new Person(); // --> not possible

    Person p = new Employee();
    System.out.println(p.getAge());
    System.out.println(p.age);
}
}

class Employee extends Person {
    int age = 2;
    int heightCm = 156;

    public int getAge() {
        return age;
    }
}

class Person {
    int age = 1;
    int heightCm = 100;

    public int getAge() {
        return age;
    }
}
