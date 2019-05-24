package cf.mindaugas.sdademos.javaadvanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsExample {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Jimmy", "Jill", "Joe", "Anna");

        Optional<String> firstNameInList = names.stream().findFirst();
        if(firstNameInList.isPresent()){
            System.out.println("First name in list is: " + firstNameInList.get());
        }
        else {
            System.out.println("No one found");
        }

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