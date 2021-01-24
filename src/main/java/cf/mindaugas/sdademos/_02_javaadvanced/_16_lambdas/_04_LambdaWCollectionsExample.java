package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class _04_LambdaWCollectionsExample {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<Person>() {{
            add(new Person(63, "Mindaugas"));
            add(new Person(21, "Pranas"));
            add(new Person(33, "Petras"));
        }};

        // Ex0: .forEach w/ method reference operator
        // p --> temporary variable, that forEach generates
        people.forEach(p -> System.out.println(p));
        people.forEach(System.out::println);

        // Ex1: .forEach w/ lambda
        people.forEach(person -> System.out.println(person));
        people.forEach(person -> {
            person.setAge(person.getAge() + 10);
        });

        // ... equivalent to
        for (Person p : people)
            System.out.println(p);

        // Ex2: .removeIf w/ a predicate function (a predicate function
        // .. is a special lambda expression that returns true or false)
        people.removeIf(person -> person.getAge() > 50); // this could be a predicate
        System.out.println("After removing people > 50: ");
        people.forEach(System.out::println);

        System.out.println("------ Ex3: Chaining consumers ------");
        List<Person> anotherList = new ArrayList<>();
        Consumer<Person> c1 = System.out::println; // another way to write the same thing
        Consumer<Person> c2 = anotherList::add; // x -> anotherList.add(x) or anotherList::add
        people.forEach(c1.andThen(c2));
        anotherList.forEach(c1);

        System.out.println("------ Ex4: Sorting Collections ------");
        // ... we can use Collection.sort(list, comparator) - but it is less efficient,
        // ... since Collection.sort dump the sorted collection into an array because
        // ... the collection can be backed by an array or linked list.

        // ... one way
        // anotherList.sort((Person p1, Person p2) -> {
        //     return p1.compareTo(p2);
        // });

        // ... more elegant way
        anotherList.sort(Person::compareTo);
        anotherList.forEach(System.out::println);
    }
}

class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return -1 * this.age - o.age;
    }
}
