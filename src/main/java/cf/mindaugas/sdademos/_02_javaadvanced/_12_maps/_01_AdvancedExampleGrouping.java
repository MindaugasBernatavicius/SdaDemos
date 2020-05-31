package cf.mindaugas.sdademos._02_javaadvanced._12_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _01_AdvancedExampleGrouping {
    private static List<Person> persons = new ArrayList<>();

    private static Map<String, List<Person>> mapByFirstName = new HashMap<>();
    private static Map<String, List<Person>> mapByLastName = new HashMap<>();
    private static Map<Integer, List<Person>> mapByAge = new HashMap<>();

    public static List<Person> searchByFirstName(String firstName){
        return mapByFirstName.getOrDefault(firstName, new ArrayList<>());
    }

    public static List<Person> searchByLastName(String lastName){
        return mapByLastName.getOrDefault(lastName, new ArrayList<>());
    }

    public static List<Person> searchByAge(int age){
        return mapByAge.getOrDefault(age, new ArrayList<>());
    }


    public static void main(String[] args){
        persons.add(new Person("John", "Jones", 31));
        persons.add(new Person("Merlin", "More", 41));
        persons.add(new Person("Berry", "More", 31));

        for(Person p : persons){
            // create the key associated List when it does not exist at first
            if(!mapByFirstName.containsKey(p.getFirstName()))
                mapByFirstName.put(p.getFirstName(), new ArrayList<>());

            // if we already have the key inside the map, we just
            // ... add a Person to the ArrayList associated with that key.
            List<Person> tmpList = mapByFirstName.get(p.getFirstName());
            tmpList.add(p);
        }

        for(Person p : persons){
            if(!mapByLastName.containsKey(p.getLastName()))
                mapByLastName.put(p.getLastName(), new ArrayList<>());
            mapByLastName.get(p.getLastName()).add(p);
        }

        for(Person p : persons){
            if(!mapByAge.containsKey(p.getAge()))
                mapByAge.put(p.getAge(), new ArrayList<>());
            mapByAge.get(p.getAge()).add(p);
        }

        System.out.println(searchByAge(31));
        System.out.println(searchByLastName("Jones"));
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return String.format("<Person: firstName %s lastName %s age %d>", firstName, lastName, age);
    }
}
