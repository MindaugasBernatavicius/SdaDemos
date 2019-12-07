package cf.mindaugas.sdademos.javaadvanced._16_lambdas;

import java.util.function.Predicate;

public class _00_Predicate {
    public static void main(String[] args) {
        // 0. Simple use case of lambda expressions
        Student student = new Student("Jimmy", "Dog", 23);
        Predicate<Student> checker = new IsAdult(); // w/o lambda
        Predicate<Student> lambda = (Student s) ->
                    { return (s.age >= 18 && s.firstName != ""); }; // w/ lambda complex
//        Predicate<Student> lambda = p -> p.age >= 18; // w/ lambda simple

        // ... Predicate<T> is a generic functional interface
        // .... representing a single argument function that returns a boolean value.

        System.out.println("Is student older than 18: " + checker.test(student));
        System.out.println("Is student older than 18: " + lambda.test(student));

        // 1. Implementing a test or String to see if it starts with some value
        Predicate<String> startsWithABCTest = s -> s.startsWith("ABC");
        System.out.println(startsWithABCTest.test("ABCDEF"));
        System.out.println(startsWithABCTest.test("XYZABG"));
    }
}

class Student {
    public String firstName;
    public String lastName;
    public int age;
    public Student(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

class IsAdult implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        return student.age >= 18;
    }
}
