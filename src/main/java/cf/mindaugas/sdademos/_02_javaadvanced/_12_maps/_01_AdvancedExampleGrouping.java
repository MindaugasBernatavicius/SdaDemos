package cf.mindaugas.sdademos._02_javaadvanced._12_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _01_AdvancedExampleGrouping {
    private static final List<Person> people = new ArrayList<>();
    private static final Map<String, List<Person>> firstNameToPeople = new HashMap<>();
    private static final Map<String, List<Person>> mapByLastName = new HashMap<>();
    private static final Map<Integer, List<Person>> ageToPeople = new HashMap<>();

    public static List<Person> searchByFirstName(String firstName) {
        return firstNameToPeople.getOrDefault(firstName, new ArrayList<>());
    }

    public static List<Person> searchByLastName(String lastName) {
        return mapByLastName.getOrDefault(lastName, new ArrayList<>());
    }

    public static List<Person> searchByAge(int age) {
        return ageToPeople.getOrDefault(age, new ArrayList<>());
    }


    public static void main(String[] args) {
        people.add(new Person("John", "Jones", 31));
        people.add(new Person("Merlin", "More", 41));
        people.add(new Person("Berry", "More", 31));

        for (Person p : people) {
            // create the key associated List when it does not exist at first
            if (!firstNameToPeople.containsKey(p.getFirstName()))
                firstNameToPeople.put(p.getFirstName(), new ArrayList<>());

            // if we already have the key inside the map, we just
            // ... add a Person to the ArrayList associated with that key.
            List<Person> tmpList = firstNameToPeople.get(p.getFirstName());
            tmpList.add(p);
        }

        for (Person p : people) {
            if (!mapByLastName.containsKey(p.getLastName()))
                mapByLastName.put(p.getLastName(), new ArrayList<>());
            mapByLastName.get(p.getLastName()).add(p);
        }

        for (Person p : people) {
            if (!ageToPeople.containsKey(p.getAge()))
                ageToPeople.put(p.getAge(), new ArrayList<>());
            ageToPeople.get(p.getAge()).add(p);
        }

        System.out.println(searchByAge(31));
        System.out.println(searchByLastName("Jones"));
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("<Person: firstName %s lastName %s age %d>", firstName, lastName, age);
    }
}
