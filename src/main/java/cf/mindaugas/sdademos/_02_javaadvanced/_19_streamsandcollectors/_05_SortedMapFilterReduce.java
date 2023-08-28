package cf.mindaugas.sdademos._02_javaadvanced._19_streamsandcollectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _05_SortedMapFilterReduce {
    public static void main(String[] args) {

        List<PersonForStreams> people = new ArrayList<PersonForStreams>() {{
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

        // sorting by two fields:
        System.out.println("==========================");
        people.stream()
                .sorted(Comparator.comparing((PersonForStreams p) -> p.getName())
                        .thenComparing((PersonForStreams p) -> p.getAge()))
                .forEach(System.out::println);

        System.out.println("---- calculating average ----");
        double averageAge = people.stream()
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();

        System.out.println("Average age:" + averageAge);

        // Exercise: Let's assume we have a list of people. We would like
        // ... to get the average age of people named "Thomas".
        System.out.println("---- calculating average for Thomas' ----");
        double averageAgeForThomases = people.stream()
                .filter(person -> person.getName().equals("Thomas"))
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();
        System.out.println("Average age for Thomas' : " + averageAgeForThomases);



        // average
        // get the averate lenght of a persons name for all names that are > 4 letters long
        var averageLengthOfLongerNames = List.of("John Johnaton", "Max Maximilian", "Alikosa Frisko", "Zoro Zoroani", "Mango Kiwi")
                .stream()
                .map(s -> s.split(" ")[0])
                .filter(s -> s.length() > 4)
                .mapToInt(s -> s.length())
                .average();
        System.out.println(averageLengthOfLongerNames.getAsDouble());

        // var il = List.of("John Johnaton", "Max Maximilian", "Alikosa Frisko", "Zoro Zoroani", "Mango Kiwi");
        // var counter = new AtomicInteger();
        // var averageLengthOfLongerNames = il
        //         .stream()
        //         .map(s -> s.split(" ")[0])
        //         // .filter(s -> s.length() > 4)
        //         .mapToDouble(String::length)
        //         .reduce(0.0, (acc, next) -> {
        //             if(il.size()-1 == counter.get()) {
        //                 return (acc + next) / il.size();
        //             } else {
        //                 counter.getAndIncrement();
        //                 return acc + next;
        //             }
        //         });
        // System.out.println(averageLengthOfLongerNames);
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
