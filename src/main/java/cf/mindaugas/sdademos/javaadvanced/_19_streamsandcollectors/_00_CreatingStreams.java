package cf.mindaugas.sdademos.javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class _00_CreatingStreams {
    public static void main(String[] args){

        // 0. Creating from collections
        List<String> names = Arrays.asList("Jimmy", "Jill", "Joe", "Anna");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);

        s = names.stream();
        // IllegalStateException: stream has already been operated upon or closed
        // s.forEach(System.out::println);
        // what if we wanted to call .andThen from the Consumer class?
        // s.forEach(((Consumer<String>)System.out::println).andThen(System.out::println));

        // 1. FindFirst() example
        Optional<String> firstNameInList = names.stream().findFirst();
        if(firstNameInList.isPresent()){
            System.out.println("First name in list is: " + firstNameInList.get());
        } else {
            System.out.println("No one found");
        }

        // 1. FindAny() example
        Optional<String> firstName = names.stream().findAny();
        firstName.ifPresent(System.out::println);
    }
}
