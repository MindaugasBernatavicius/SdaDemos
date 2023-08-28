package cf.mindaugas.sdademos._02_javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class _02_MapAndCollectors {

    public static void _00_(){
        // Convert all string numbers into integers and return the even ones
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        System.out.println("original list: " + numbers);

        List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + even);
    }

    public static void _02_MapComboWithFilterAndExceptions(){
        List<String> numbers = Arrays.asList("1", "2", "B", "3", "4922", "5", "6", "A");
        System.out.println("original list: " + numbers);

        // List<Integer> numberAsInts = numbers.stream()
        //         .map(s -> {
        //             Integer result = null;
        //             try {
        //                 result = Integer.valueOf(s);
        //             } catch (NumberFormatException e){
        //                 // System.out.println(e);
        //             }
        //             return result;
        //         })
        //         .filter(Objects::nonNull)
        //         .toList();
        // System.out.println(numberAsInts);

        // ... to avoid dealing with exceptions, we can prevent them from happening by filtering first
        numbers.stream()
                .filter(s -> s.matches("\\d+"))
                .map(Integer::valueOf)
                .map(integer -> integer * integer)
                .forEach(System.out::print);
    }

    public static void _01_(){
        // var strings = List.of(List.of("Jonas"), List.of("Petras"),  List.of("Antanas"));
        var strings = List.of(List.of("Jonas"), List.of("Petras"),  List.of("Antanas"));
        // strings.stream().map(strs -> strs).forEach(System.out::println);
        strings.stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    public static void main(String[] args) {
        // _00_();
        // _01_();
        _02_MapComboWithFilterAndExceptions();
    }
}
