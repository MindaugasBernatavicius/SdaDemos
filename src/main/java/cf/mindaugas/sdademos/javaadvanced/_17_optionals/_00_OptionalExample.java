package cf.mindaugas.sdademos.javaadvanced._17_optionals;

import java.util.Optional;

public class _00_OptionalExample {
    public static void main(String[] args) {
        String stringVariable = null;
//        Optional<String> stringOptional = Optional.of(stringVariable);
        Optional<String> stringOptional = Optional.ofNullable(stringVariable);

        // returns true if value is present
        stringOptional.isPresent();

        if(stringOptional.isPresent()) {
            String value = stringOptional.get();
        }

        // Prints value if it is present
        stringOptional.ifPresent(System.out::println);

        String value = stringOptional.orElse("default value");
    }
}
