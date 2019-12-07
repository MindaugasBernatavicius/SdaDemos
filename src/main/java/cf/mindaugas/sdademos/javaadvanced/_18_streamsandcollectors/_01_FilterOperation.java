package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _01_FilterOperation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Joe", "Anna", "Mindaugas");

        Optional<String> resultOfFilter = names
                .stream()
                .parallel()
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
