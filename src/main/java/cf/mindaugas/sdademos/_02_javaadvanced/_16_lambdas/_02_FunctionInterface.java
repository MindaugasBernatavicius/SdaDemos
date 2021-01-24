package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

import java.util.function.Function;

public class _02_FunctionInterface {

    public static int calcSomething(Integer[] array, Function<Integer[], Integer> summarizer) {
        // ... more logic
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
        // Function<INPUT_TYPE, OUTPUT_TYPE>
        // Function<String, Integer> stringLengthFunction = s -> s.length(); // int --> Integer (autoboxing)
        // System.out.println(stringLengthFunction.apply("ABCDEF"));

        // Method apply returns String and the type of the parameter is String
        // Function<String, String> replaceCommasWithDotsFunction = s -> s.replace(',', '.');
        // System.out.println(replaceCommasWithDotsFunction.apply("a,b,c"));

        // Two "functions" that are being passed to another function
        // Integer[] simpleArray = {1, 2, 3, 4, 5};
        // int resultSum = calcSomething(simpleArray, (arr) -> {
        //     int sum = 0;
        //     for(int number : arr)
        //         sum += number;
        //     return sum;
        // });
        // System.out.println("Result of sum add lambda: " + resultSum);
        //
        // int resultMultiply = calcSomething(simpleArray, (data) -> {
        //     int multiply = 0;
        //     for(int number : data)
        //         multiply *= number;
        //     return multiply;
        // });
        // System.out.println("Result of multiply lambda: " + resultMultiply);


        // ... Other functional interfaces
        // Supplier and Consumer
        // Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt();
        // int randomNumber = randomNumberSupplier.get();
        //
        // // ... Consumer presents a method, that return nothing, but changes "the state of the world"
        // Consumer<Double> printWithPrefixConsumer = d -> System.out.println("Value: " + d);
        // printWithPrefixConsumer.accept(10.5);

        // Operator
        // Function<Integer, Integer> squaring = i -> i * i;
        // UnaryOperator<Integer> exactlyTheSameFn = i -> i * i;
        // UnaryOperator<Integer> exactlyTheSameFn = i -> {
        //     System.out.println("");
        //     return i * i;
        // };
        // System.out.println(exactlyTheSameFn.apply(5));

        // Dažnai java pradednatiji prigramuotojai, nori turėti funkciją, kuri
        // ... priima ne tik kintamuosius, bet ir operaciją, kurią norime, kad ta
        // ... funkcija atliktų. Lambda išraiškos su funkciniais interface'ais, leidžia
        // ... tai padaryti!
        // function calculate(int[] myNumbers, Function<Integer, Integer> myf)
        // myf.apply()
    }
}
