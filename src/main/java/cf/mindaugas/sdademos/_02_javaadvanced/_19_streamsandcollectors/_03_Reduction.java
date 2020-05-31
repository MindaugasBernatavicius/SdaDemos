package cf.mindaugas.sdademos._02_javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _03_Reduction {
    public static void main(String[] args) {
        // // 0. In built reductions
        // int vals[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        // int sum = Arrays.stream(vals).sum();
        // System.out.printf("The sum of values: %d%n", sum);

        // 1. More explicitly, without using in-built reductions
        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
        // Finding sum of all elements
        // - initial value --> 0
        // - partialResult --> represents the result of all the previous operations
        // - currentElement --> just the next element from the stream
        int sum = array.stream().reduce(0,
                (partialResult, currentElement) -> partialResult + currentElement);

        // int sum = 0;
        // for(){
        //     sum += arr[i];
        // }

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);

        // 2. Max algorithm using reduce() function
        List<Car> cars = Arrays.asList(
                new Car("Skoda", 18544),
                new Car("Volvo", 22344),
                new Car("Fiat", 23650),
                new Car("Renault", 19700)
        );

        Optional<Car> car = cars.stream().reduce((c1, c2)
                -> c1.getPrice() > c2.getPrice() ? c1 : c2);
        car.ifPresent(System.out::println);

        // 2. More complex example - string concatenation
        // Initial value is empty string.
        // If current result value is an empty string we simply add element to an empty string,
        // otherwise we concatenate current value, ", " and element.
        List<String> names = Arrays.asList("Andrew", "Bu", "Michael");
        String namesConcatenation = names.stream()
                // .reduce("", (currValue, element) -> currValue + ", " + element);
                .reduce("", (currValue, element) -> (currValue.equals("") ? "" : currValue + ", ") + element);
        // 0. currValue -> "" ... returned "" + "Andrew"
        // 1. currValue -> "" + "Andrew" ... returned "" + "Andrew" + ", " + "Bu"
        // 2. currValue -> "" + "Andrew" + ", " + "Bu" ... returned "" + "Andrew" + ", " + "Bu" + ", " + "Michael"
        System.out.println(namesConcatenation);
    }
}

class Car {

    private final String name;
    private final int price;

    public Car(String name, int price) {

        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Car{name=").append(name).append(", price=")
                .append(price).append("}");

        return builder.toString();
    }
}
