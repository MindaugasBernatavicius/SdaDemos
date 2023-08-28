import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Item {}


public class ScratchPad {

    public static void main(String[] args) {
        var strings = List.of(List.of("Jonas"), List.of("Petras"),  List.of("Antanas"));
        // strings.stream().map(strs -> strs).forEach(System.out::println);
        strings.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
