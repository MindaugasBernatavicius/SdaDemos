package cf.mindaugas.sdademos._02_javaadvanced._10_generics;

import java.util.List;

public class _05_LowerBUpperBAndUnbounded {
    public static void main(String[] args) { }

    // Upper bounded wildcard
    // Read: everything that is a HumanBeing and below it
    public <T extends HumanBeing> void doSomething(T param){
        param.sayName("Mindaugas");
    }

    // Lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type.
    // You want to write a method that puts Integer objects into a list.
    // To maximize flexibility, you would like the method to work on
    // List<Integer>, List<Number>, and List<Object> — anything that can hold Integer values.
    // Read: everything that is an integer and above it!
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}

class HumanBeing {
    protected void sayName(String name){
        System.out.println(name);
    }
}

class Employee extends HumanBeing { }
class Teacher extends Employee {}
