package cf.mindaugas.sdademos._02_javaadvanced._12_maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _00_CreateAddIterateRemove {
    public static void main(String[] args) {
        // simple example
        // Map<K, V> --> Map<String, Integer>
        Map<String, Integer> m = new HashMap<>();
        m.put("one", 1);
        m.put("two", 2);
        m.put("three", 3);
        System.out.println(m.get("two"));

        // ... a more complex example
        Map<String, List<String>> synonyms = new HashMap<>();
        synonyms.put("flower", Arrays.asList("herb", "vine", "floret"));
        System.out.println(synonyms.getOrDefault("flower", Arrays.asList()));
        System.out.println(synonyms.getOrDefault("grass", Arrays.asList("blah")));

        // ... iterating
        for (Map.Entry<String, List<String>> pair : synonyms.entrySet()) {
            // default formatting (printing the entire pair)
            System.out.println(pair);
            // if custom formatted is needed (printing what we need, key, value or both)
            System.out.println(pair.getKey() + " :: " + pair.getValue());
        }

        // ... remove
        System.out.println("\nBefore removal: " + m);
        m.remove("two");
        System.out.println("After removal: " + m);
    }
}
