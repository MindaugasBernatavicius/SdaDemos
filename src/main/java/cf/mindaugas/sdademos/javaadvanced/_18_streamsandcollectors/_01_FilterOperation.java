package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _01_FilterOperation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jimmy", "Jill", "Joe", "Anna");

        Optional<String> resultOfFilter = names
                .stream()
                .parallel()
                .map(p -> p.toUpperCase())
                .filter(p -> p.charAt(0) == 'J')
                .map(x -> x.replace("M", "o"))
                .findAny();

        if(resultOfFilter.isPresent()){
            System.out.println("Filtered result: " + resultOfFilter.get());
        }
        else {
            System.out.println("No one found");
        }
    }
}
