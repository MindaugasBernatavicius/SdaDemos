package cf.mindaugas.sdademos.javaadvanced._02_inheritence;

public class Driver {
    public static void main(String[] args) {
        // Employee e = new Person(); --> not possible

        Person p = new Employee();
        System.out.println(p.getAge());
        System.out.println(p.heightCm);
    }
}
