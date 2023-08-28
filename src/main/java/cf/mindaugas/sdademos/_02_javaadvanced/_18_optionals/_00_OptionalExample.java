package cf.mindaugas.sdademos._02_javaadvanced._18_optionals;

import java.util.List;
import java.util.Optional;

public class _00_OptionalExample {
    public static void main(String[] args) {
        String stringVariable = null;
        // Optional<String> stringOptional = Optional.of(stringVariable);
        Optional<String> stringOptional = Optional.ofNullable(stringVariable);

        // returns true if value is present
        stringOptional.isPresent();

        if (stringOptional.isPresent()) { // value != null
            String value = stringOptional.get();
            System.out.println(value);
        }

        // Prints value if it is present
        stringOptional.ifPresent(System.out::println);
        String value = stringOptional.orElse("default value");
        System.out.println(value);

        // ... example with filter
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        if (is2016)
            System.out.println(yearOptional.get());

        // ... passing optional to a function
        int sum = sum(Optional.of(1), Optional.of(2));
        System.out.println("Sum:" + sum);




        Optional<String> res = List.of("AB", "BB", "BD", "BC").stream()
                .filter(s -> s.startsWith("B")).findAny();

        // 0.
        // res.ifPresentOrElse(System.out::println, () -> System.out.println("No value found"));

        // 1.
        // res.ifPresent(System.out::println);
        // res.orElse("No one found");

        // 2.
        if(res.isEmpty())
            System.out.println("No one found");
        else
            System.out.println(res.get());

    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}
