package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._04_iterator.nonsda;

import java.util.*;

public class _01_Iterator {
    public static void main(String[] args) {
        // List<String> names = new ArrayList<>();
        // names.add("Mindaugas");
        // names.add("Jonas");
        // names.add("Antanas");
        // // we controll how big is the step (i++)
        // // ... how many items we will iterate over (< names.size())
        // // ... where we start (int i = 0)
        // for(int i = 0; i < names.size(); i++) {
        //     String name = names.get(i);
        // }

        Set<String> names = new HashSet<>();
        names.add("Mindaugas");
        names.add("Jonas");
        names.add("Antanas");

        Iterator<String> namesItr = names.iterator();
        while (namesItr.hasNext()) {
            String name = namesItr.next();
            System.out.println(name);
            // namesItr.remove();
        }

        // for (String name : names) {
        //     System.out.println(name);
        // }

        // System.out.println("Names size: " + names.size());
    }
}
