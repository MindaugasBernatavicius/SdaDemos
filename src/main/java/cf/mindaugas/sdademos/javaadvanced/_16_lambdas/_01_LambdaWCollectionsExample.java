package cf.mindaugas.sdademos.javaadvanced._16_lambdas;

import java.util.ArrayList;
import java.util.List;

public class _01_LambdaWCollectionsExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>() {{
            add(new Person(63, "Mindaugas"));
            add(new Person(21, "Pranas"));
            add(new Person(33, "Petras"));
        }};

        // Ex0: .forEach w/ method reference operator
        people.forEach(System.out::println);

        // Ex1: .forEach w/
        people.forEach(person -> System.out.println(person));

        // Ex2: .removeIf w/ a predicate function (a predicate function
        // .. is a special lambda expression that returns true or false)
        people.removeIf(person -> person.getAge() > 50);
        System.out.println();
        people.forEach(System.out::println);
    }
}

class Person {
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
}
