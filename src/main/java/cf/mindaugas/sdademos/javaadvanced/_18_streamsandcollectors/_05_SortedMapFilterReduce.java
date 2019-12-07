package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _05_SortedMapFilterReduce {
    public static void main(String[] args) {

        List<PersonForStreams> people = new ArrayList<PersonForStreams>(){{
            add(new PersonForStreams(15, "Thomas"));
            add(new PersonForStreams(22, "Mindaugas"));
            add(new PersonForStreams(5, "Thomas"));
            add(new PersonForStreams(22, "Petras"));
        }};

        System.out.println("---- sorting by Name ----");
        people.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("---- sorting by Age + another syntax ----");
        people.stream()
                .sorted(Comparator.comparing(PersonForStreams::getAge))
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("---- calculating average ----");
        double averageAge = people.stream()
                .mapToInt(p-> p.getAge())
                .average().getAsDouble();

        System.out.println("Average age:" + averageAge);

        // Exercise: Let's assume we have a list of people. We would like
        // ... to get the average age of people named "Thomas".
        System.out.println("---- calculating average for Thomas' ----");
        double averageAgeForThomases = people.stream()
                .filter(person -> person.getName().equals("Thomas"))
                .mapToInt(p-> p.getAge())
                .average().getAsDouble();
        System.out.println("Average age for Thomas' : " + averageAgeForThomases);

    }
}

class PersonForStreams {
    private int age;
    private String name;

    public PersonForStreams(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}