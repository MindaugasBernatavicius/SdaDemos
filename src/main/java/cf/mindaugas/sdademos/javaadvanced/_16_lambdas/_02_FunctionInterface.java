package cf.mindaugas.sdademos.javaadvanced._16_lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class _02_FunctionInterface {

    public static int calcSomething(
            Integer[] array, Function<Integer[], Integer> summarizer){
        return summarizer.apply(array);
    }

    public static void main(String[] args) {

        // 0. We have the ability to carry around functional interface types
        // ... as objects. Which makes java a bit closer to the functional programming parading
        // ... where functions can be passed to other functions
        // In Java everything has a type, so what is the type of lambda expression? Functional interface
        // ... a functional interface is an interface with one abstract method (Runnable, Comparable, FileFilter)
        // ... all became functional interfaces in Java 8 (method from the object class do not count).

        // Lambda is created w/o the keyword new, it it less expensive for the JVM

        // Method apply returns Integer and the type of the parameter is String
        Function<String, Integer> stringLengthFunction = s -> s.length();
        System.out.println(stringLengthFunction.apply("ABCDE"));

        // Method apply returns String and the type of the parameter is String
        Function<String, String> replaceCommasWithDotsFunction = s -> s.replace(',', '.');
        System.out.println(replaceCommasWithDotsFunction.apply("a,b,c"));

        // Two "functions" that are being passed to another function
        Integer[] simpleArray = {1, 2, 3, 4, 5};
        int resultSum = calcSomething(simpleArray, (data) -> {
            int sum = 0;
            for(int number : data)
                sum += number;
            return sum;
        });
        System.out.println("Result of sum add lambda: " + resultSum);

        int resultMultiply = calcSomething(simpleArray, (data) -> {
            int multiply = 0;
            for(int number : data)
                multiply *= number;
            return multiply;
        });
        System.out.println("Result of multiply lambda: " + resultMultiply);


        // ... Other function interfaces
        // Supplier and Consumer

        // Operator
        Function<Integer, Integer> squaring = i -> i * i;
        UnaryOperator<Integer> exactlyTheSameFn = i -> i * i;
        System.out.println(exactlyTheSameFn.apply(5));
    }
}