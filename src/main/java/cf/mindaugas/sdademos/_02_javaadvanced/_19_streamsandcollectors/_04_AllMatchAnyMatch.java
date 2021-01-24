package cf.mindaugas.sdademos._02_javaadvanced._19_streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _04_AllMatchAnyMatch {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Andrew", "Bu", "Michael");
        boolean allNamesLengthIsGtThan3 = names.stream().allMatch(n -> n.length() > 3);
        boolean thereIsANameWhichLengthIsGtThan3 = names.stream().anyMatch(n -> n.length() > 3);

        // // names.stream().anyMatch(n -> n.length() > 3);
        // // equivalent in imperative style, procedural programming is this:
        // boolean nameWithMoreThan3LettersExists = false;
        // for (String name: names) {
        //     if(name.length() > 3){
        //         nameWithMoreThan3LettersExists = true;
        //         break;
        //     }
        // }

        if (allNamesLengthIsGtThan3) {
            System.out.println("All names are longer than 3 chars!");
        } else if (thereIsANameWhichLengthIsGtThan3) {
            List<String> nl = names
                    .stream()
                    .filter(n -> n.length() > 3)
                    .collect(Collectors.toList());
            System.out.println("There are names longer than 3 chars! They are: " + nl);
        } else {
            System.out.println("There are no names longer than 3 chars!");
        }
    }
}
