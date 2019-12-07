package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class _00_CreatingStreams {
    public static void main(String[] args){

        List<String> names = Arrays.asList("Jimmy", "Jill", "Joe", "Anna");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // s.forEach(((Consumer<String>)System.out::println).andThen(System.out::println));
        Optional<String> firstNameInList = s.findFirst();

        if(firstNameInList.isPresent()){
            System.out.println("First name in list is: " + firstNameInList.get());
        } else {
            System.out.println("No one found");
        }
    }
}
