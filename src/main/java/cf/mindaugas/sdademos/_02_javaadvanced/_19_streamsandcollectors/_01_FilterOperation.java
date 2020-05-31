package cf.mindaugas.sdademos._02_javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _01_FilterOperation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Joe", "Anna", "Mindaugas");

        // 0. Simple example
        List<String> namesStartingWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(namesStartingWithA);

        // 1. More complex example
        Optional<String> resultOfFilter = names
                .stream().parallel()
                .map(p -> p.toUpperCase())
                .filter(p -> p.charAt(0) == 'J')
                .map(x -> x.replace("O", "M"))
                .findAny();

        if(resultOfFilter.isPresent())
            System.out.println("Filtered result: "
                    + resultOfFilter.get());
        else
            System.out.println("No one found");


        System.out.print("Filtered result: ");
        resultOfFilter.ifPresent(System.out::println);
        resultOfFilter.orElse("No one found");

        // use method references when you don't have to
        // perform any new operations on the data returned
        // from an optional
        resultOfFilter.ifPresent(res -> {
            String result = res.toLowerCase() + "!";
            System.out.println("Filtered result: " + result);
        });
    }
}
