package cf.mindaugas.sdademos.javaadvanced._11_collections;

import java.util.*;
import java.util.Arrays;

public class CollectionsExamples {

    // 0. Initializing a collection - creating a collection object
    public static void collectionAddAndIterate() {
        List<Integer> arrayListOfInts = new ArrayList<>();
        List<Integer> linkedListOfInts = new LinkedList<>();
        Set<Integer> setOfInts = new HashSet<>();

        Random rnd = new Random();

        // 1. Adding elements to a collection
        System.out.println("Array List");
        for(int i = 0; i < 100; i++){
            arrayListOfInts.add(rnd.nextInt(100));
        }
        System.out.println("Size: " + arrayListOfInts.size());

        System.out.println("Linked List");
        for(int i = 0; i < 100; i++){
            linkedListOfInts.add(rnd.nextInt(100));
        }
        System.out.println("Size: " + linkedListOfInts.size());

        System.out.println("Set");
        for(int i = 0; i < 100; i++){
            setOfInts.add(rnd.nextInt(100));
        }
        System.out.println("Size: " + setOfInts.size());
    }

    // 2. Removing elements from collections one by one
    public static void removingOneByOne(){
        List<Person> listForRemovalOfElement = new ArrayList<>();
        listForRemovalOfElement.add(new Person(44, "Mindaugas"));
        listForRemovalOfElement.add(new Person(22, "Jonas"));

        listForRemovalOfElement.remove(new Person(44, "Mindaugas"));
        // listForRemovalOfElement.remove(0); // removing by index

        for(Person p : listForRemovalOfElement)
            System.out.println(p);
    }

    // 3. Adding many items from one collection to another at once
    public static void addingInBulk(){
        List<Person> listForAddingInBulk = new ArrayList<>();
        listForAddingInBulk.add(new Person(44, "Mindaugas"));
        listForAddingInBulk.add(new Person(22, "Jonas"));

        List<Person> listForAddingManyElements = new ArrayList<Person>() {{
            add(new Person(33, "Petras"));
            add(new Person(21, "Pranas"));
            add(new Person(33, "Petras"));
        }};

        listForAddingInBulk.addAll(listForAddingManyElements);

        for(Person p : listForAddingInBulk)
            System.out.println(p);
        System.out.println();
    }

    // 4. Adding items from List to Set
    public static void addingFromListToSet(){
        List<Person> listForAddingInBulk = new ArrayList<>();
        listForAddingInBulk.add(new Person(44, "Mindaugas"));
        listForAddingInBulk.add(new Person(22, "Jonas"));
        listForAddingInBulk.add(new Person(22, "Jonas"));

        // ... HashSet requires hashCode() method
        // ... to be implemented by the T inside Set<T>
        Set<Person> setOfPeople = new HashSet<>();
        setOfPeople.addAll(listForAddingInBulk);
        for(Person p : setOfPeople)
            System.out.println(p);
    }

    // 5. Removing in bulk (equality)
    public static void removingInBulk(){

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
    }

    // 6. Multidimensional collections
    public static void multidimensionalLists(){
        System.out.println("---- Multidimensional collections ----");
        List<Person> students = new ArrayList<Person>(){{
            add(new Person(22, "Mindaugas"));
        }};
        List<Person> teachers = new ArrayList<Person>(){{
            add(new Person(44, "Petras"));
            add(new Person(42, "Antanas"));
        }};

        // Similar to 2D Array
        List<List<Person>> school = new ArrayList<List<Person>>(){{
            add(students);
            add(teachers);
        }};

        // ... or like this
        // List<List<Person>> school = new ArrayList<>();
        // school.add(students);
        // school.add(teachers);

        // ... using a simple enhanced for to iterate over a list
        for(Person p : teachers){
            System.out.println(p);
        }

        // ... another way of iterating over a collection
        Iterator<Person> ti = teachers.iterator();
        while (ti.hasNext()) {
            System.out.print(ti.next() + " ");
        }

        // ... and we can iterate over 2D List
        for (List<Person> people: school) {
            for (Person person: people) {
                System.out.println(person);
            }
        }

        // ... and doing the same with iterator
        System.out.println("--- Iterating 2D list with iterator ---");
        Iterator<List<Person>> si = school.iterator();
        while (si.hasNext()) {
            System.out.println(si.next() + " ");
//            Iterator<Person> pi2 = si.next().iterator();
//            while(pi2.hasNext()){
//                System.out.println(pi2.next() + " ");
//            }
        }
    }

    // 7. Jagged Multidimensional Lists
    public static void jaggedLists(){
        // ... we can also store unequal size arrays in the List (jagged lists)
        System.out.println("---- Unequal (jagged) arrays inside List ----");
        List<String[]> listOfStringArrays = new ArrayList<String[]>(){{
            add(new String[]{"Mindaugas", "Jonas"});
            add(new String[]{"Petras", "Vaidas", "Sonata"});
        }};

        for(String[] arr: listOfStringArrays){
            System.out.println(Arrays.toString(arr));
        }
    }

    // 8. From lists to Arrays
    public static void fromListsToArrays(){
        // 8. Converting collections to arrays (typed) : List-to-array
        System.out.println("---- Converting collections to arrays ----");
        // ... simple example
        List<String> itemList = new ArrayList<>();
        itemList.add("item1");
        itemList.add("item2");
        itemList.add("item3");

        String[] itemsArray = new String[itemList.size()];
        itemsArray = itemList.toArray(itemsArray);

        for(String s : itemsArray)
            System.out.println(s);

        // ... more advanced example
        List<String[]> listOfStringArrays = new ArrayList<String[]>(){{
            add(new String[]{"Mindaugas", "Jonas"});
            add(new String[]{"Petras", "Vaidas", "Sonata"});
        }};
        String[][] itemsArray2 = listOfStringArrays.toArray(new String[][]{});

        for(String[] a: itemsArray2){
            for(String s: a){
                System.out.println(s);
            }
        }
    }

    // 9. From arrays to lists
    public static void fromArraysToLists(){
        System.out.println("---- Converting arrays to collections ----");
        Integer[] spam = new Integer[]{ 1, 2, 3 };
        List<Integer> list = Arrays.asList(spam);
        System.out.println(list);
    }

    // 10. Sorting a collection of Strings
    public static void sortingCollectionOfStrings(){
        // Sorting a collection
        List<String> al = new ArrayList<>();
        al.add("Geeks");
        al.add("Friends");
        al.add("Students");

        System.out.println("List BEFORE the use " +
                "of Collection.sort() : " + al);

        // ... Collections.sort method is sorting the elements
        // ... of ArrayList in ascending order.
        Collections.sort(al);

        // ... let us print the sorted list
        System.out.println("List AFTER the use " +
                "of Collection.sort() : " + al);

        // ... to sort a List objects you created, you need to compare them
    }

    // 11. Searching a collection of String using inbuilt methods
    public static void searchingACollectionOfStrings(){
        List<String> al = new ArrayList<>();
        al.add("Geeks");
        al.add("Friends");
        al.add("Students");
        // X. Searching a collection (binary search / linear search)
        System.out.println(Collections.binarySearch(al, "Students"));

        // ... linear search is obviously just a for loop
    }

    // 12. Sorting a List of Strings in reverse order
    public static void sortingStringsInReverse(){
        List<String> al = new ArrayList<>();
        al.add("Geeks");
        al.add("Friends");
        al.add("Students");
        Collections.sort(al, Collections.reverseOrder());
        System.out.println(al);
    }

    // 13. Sorting a List of custom objects (difference btw/
    // ... Collection.sort() and List.sort()
    public static void sortingListofCustomObjects(){
        List<Person> listForAddingInBulk = new ArrayList<>();
        listForAddingInBulk.add(new Person(44, "Mindaugas"));
        listForAddingInBulk.add(new Person(22, "Jonas"));
        listForAddingInBulk.add(new Person(22, "Jonas"));

        System.out.println("Before sorting: " + listForAddingInBulk);
        Collections.sort(listForAddingInBulk, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("After sorting: " + listForAddingInBulk);
    }

    public static void main(String[] args){
//        collectionAddAndIterate();
//        removingOneByOne();
//        addingInBulk();
//        addingFromListToSet();
//        removingInBulk();
//        multidimensionalLists();
//        jaggedLists();
//        fromListsToArrays();
//        fromArraysToLists();
//        sortingCollectionOfStrings();
//        searchingACollectionOfStrings();
//        sortingStringsInReverse();
        sortingListofCustomObjects();
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
