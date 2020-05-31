package cf.mindaugas.sdademos._04_codingadvanced.v2questions;

import java.time.LocalDate;

public class QuestionAboutDateUsage {
    public static void main(String[] args) {
        Person mindaugas = new Person("Mindaugas", "1999-12-12");

        System.out.println(mindaugas);
    }
}

class Person {
    // ... Why don't we need age passed
    // ... to constructor or setter?

    // Ans.: age can derived from dob: LocalDate.now() - dob
    private int age;
    private String name;
    private LocalDate dob;

    public Person(String name, String dob) {
        this.name = name;
        this.dob = LocalDate.parse(dob);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
