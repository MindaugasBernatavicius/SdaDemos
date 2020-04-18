package cf.mindaugas.sdademos.javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseWithStreams {
    public static void main(String[] args) {
        String[] names = {"John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn"};
        int[] digits = {1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50};

        // 0. Sort the list
        List<String> nameList = Arrays.stream(names)
                .sorted().collect(Collectors.toList());
        System.out.println(nameList);

        // 1. Print only those names, that start with „E” letter.
        Arrays.stream(names)
                .filter(n -> n.startsWith("E"))
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\n" + Arrays.stream(names)
                .filter(n -> n.startsWith("E"))
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el));

        // 2. Print values greater than 30 and lower than 200.
        System.out.println(Arrays.stream(digits)
                .filter(n -> (n > 30 && n < 200))
                .mapToObj(String::valueOf)
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el));

        // 3. Print names uppercase.
        System.out.println(Arrays.stream(names)
                .map(String::toUpperCase)
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el));

        // 4. Remove first and last letter, sort and print names.
        System.out.println(Arrays.stream(names)
                .map(s -> s.substring(0, s.length() - 1)) // removes the last letter
                .map(s -> s.substring(1)).sorted() // removes the first letter
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el));

        // 5. *Sort backwards by implementing reverse Comparator and using lambda expression.
        System.out.println(Arrays.stream(names).sorted((s1, s2) -> s1.compareTo(s2))
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el)); // prints in the default sort order

        System.out.println(Arrays.stream(names).sorted((s1, s2) -> -(s1.compareTo(s2)))
                .reduce("", (curr, el) -> (curr.equals("") ? "" : curr + ", ") + el)); // prints in the reversed sort order
    }
}
