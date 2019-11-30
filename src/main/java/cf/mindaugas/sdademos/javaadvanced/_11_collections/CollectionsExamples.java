package cf.mindaugas.sdademos.javaadvanced._11_collections;

import java.util.*;
import java.util.Arrays;

public class CollectionsExamples {

    public static void main(String[] args){

        // ... for comparison
        int[] arrayOfInts = new int[5];

        // 0. Initializing a collection - creating a collection object
        List<Integer> arrayListOfInts = new ArrayList<>();
        List<Integer> linkedListOfInts = new LinkedList<>();
        Set<Integer> setOfInts = new HashSet<>();

        Random rnd = new Random();

        // // 1. Adding elements to a collection
        // System.out.println("Array List");
        // for(int i = 0; i < 100; i++){
        //     arrayListOfInts.add(rnd.nextInt(100));
        //     System.out.println("Size: " + arrayListOfInts.size());
        // }
        //
        // System.out.println("Linked List");
        // for(int i = 0; i < 100; i++){
        //     linkedListOfInts.add(rnd.nextInt(100));
        //     System.out.println("Size: " + linkedListOfInts.size());
        // }
        //
        // System.out.println("Set");
        // for(int i = 0; i < 100; i++){
        //     setOfInts.add(rnd.nextInt(100));
        //     System.out.println("Size: " + setOfInts.size());
        // }

        // 2. Removing elements from collections one by one
        List<Person> listForRemovalOfElement = new ArrayList<>();
        listForRemovalOfElement.add(new Person(44, "Mindaugas"));
        listForRemovalOfElement.add(new Person(22, "Jonas"));

        listForRemovalOfElement.remove(new Person(44, "Mindaugas"));

        // for(Person p : listForRemovalOfElement)
        //     System.out.println(p);



        // 3. Adding in bulk (equality)
        List<Person> listForAddingManyElements = new ArrayList<Person>() {{
            add(new Person(33, "Petras"));
            add(new Person(21, "Pranas"));
            add(new Person(33, "Petras"));
        }};

        listForRemovalOfElement.addAll(listForAddingManyElements);

        for(Person p : listForRemovalOfElement)
            System.out.println(p);
        System.out.println();


        // ... HashSet requires hashCode() method
        // ... to be implemented by the T inside Set<T>
        Set<Person> setOfPeople = new HashSet<>();
        setOfPeople.addAll(listForAddingManyElements);
        for(Person p : setOfPeople)
            System.out.println(p);

        // 4. Removing in bulk (equality)
        System.out.println("---- Removing in bulk ----");
        Set<String> arrset1 = new HashSet<String>(){{
            add("Mindaugas");
            add("Pranas");
        }};

        System.out.println("Set before retainAll() operation : " + arrset1);

        // Creating another object of  Set
        Set<String> arrset2 = new HashSet<String>(){{
            add("Mindaugas");
        }};

        System.out.println("Collection Elements to be retained : " + arrset2);

        // Leaving elements from arrset specified in arrset2 using retainAll() method
        // arrset1.retainAll(arrset2);

        // Leaving elements from arrset specified in arrset2 using retainAll() method
        arrset1.removeAll(arrset2);

        // print arrset1
        System.out.println("Set after operation : " + arrset1);



        // 5. Multidimensional collections
        System.out.println("---- Multidimensional collections ----");
        List<Person> students = new ArrayList<Person>(){{
            add(new Person(22, "Mindaugas"));
        }};
        List<Person> teachers = new ArrayList<Person>(){{
            add(new Person(44, "Petras"));
        }};

        // List<List<Person>> school = new ArrayList<List<Person>>(){{
        //     add(students);
        //     add(teachers);
        // }};

        // ... or like this
        List<List<Person>> school = new ArrayList<>();
        school.add(students);
        school.add(teachers);

        for (List<Person> people: school) {
            for (Person person: people) {
                System.out.println(person);
            }
        }

        // ... we can also store unequal size arrays in the List
        System.out.println("---- Unequal arrays ----");
        List<String[]> listOfStringArrays = new ArrayList<String[]>(){{
            add(new String[]{"Mindaugas", "Jonas"});
            add(new String[]{"Petras", "Vaidas", "Sonata"});
        }};

        for(String[] arr: listOfStringArrays){
            System.out.println(Arrays.toString(arr));
        }

        // X. Converting collections to arrays (typed)
        System.out.println("---- Converting collections to arrays ----");
        // ... simple example
        List<String> itemList = new ArrayList<String>();
        itemList.add("item1");
        itemList.add("item2");
        itemList.add("item3");

        String[] itemsArray = new String[itemList.size()];
        itemsArray = itemList.toArray(itemsArray);

        for(String s : itemsArray)
            System.out.println(s);

        // ... more advanced example
        String[][] itemsArray2 = listOfStringArrays
                .toArray(new String[][]{});

        for(String[] a: itemsArray2){
            for(String s: a){
                System.out.println(s);
            }
        }

        // X. Converting array to collection (List)
        System.out.println("---- Converting arrays to collections ----");
        Integer[] spam = new Integer[]{ 1, 2, 3 };
        List<Integer> list = Arrays.asList(spam);
        System.out.println(list);

        // X. Sorting a collection
        List<String> al = new ArrayList<>();
        al.add("Geeks");
        al.add("Friends");
        al.add("Students");

        // ... Collections.sort method is sorting the elements of ArrayList in ascending order.
        Collections.sort(al);

        // ... let us print the sorted list
        System.out.println("List after the use " +
                "of Collection.sort() :\n" + al);

        // ... to sort a List objects you created, you need to compare them

        // X. Searching a collection (binary search / linear search)
        System.out.println(Collections
                .binarySearch(al, "Students"));

        // ... linear search is obviously just a for loop

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
