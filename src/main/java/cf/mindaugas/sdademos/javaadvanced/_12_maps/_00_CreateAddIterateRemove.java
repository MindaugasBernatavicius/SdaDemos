package cf.mindaugas.sdademos.javaadvanced._12_maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _00_CreateAddIterateRemove {
    public static void main(String[] args) {
        // simple example
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
        for(Map.Entry<String, List<String>> pair : synonyms.entrySet()){
            // default formatting
            System.out.println(pair);
            // if custom formatted is needed
            System.out.println(pair.getKey() + " :: " + pair.getValue());
        }

        // ... remove
        m.remove("two");
    }
}
