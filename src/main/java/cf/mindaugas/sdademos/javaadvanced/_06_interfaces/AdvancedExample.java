package cf.mindaugas.sdademos.javaadvanced._06_interfaces;

import com.sun.istack.internal.Nullable;

import java.util.Comparator;

public class AdvancedExample {

    private static void bubbleSort(int[] inputArr){
        int counter = 0;
        boolean swapped;
        for (int i = 0; i < inputArr.length; i++) {
            swapped = false;
            for (int j = 0; j < inputArr.length - i - 1; j++) {
                counter++;
                if(inputArr[j] > inputArr[j + 1]){
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j + 1];
                    inputArr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        System.out.println("Counter: " + counter);
    }

    public static void bubbleSort(Person arr[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].age > arr[j+1].age){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortWComparableSimple(Human[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    Human temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void bubbleSortWithComparable(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0){
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void bubbleSortWithComparator(
            Human[] arr, Comparator comparator){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (comparator.compare(arr[j], arr[j+1]) > 0){
                    Human temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * bubbleSortGeneric - sorts objects that implement Comparable
     * ... using the compareTo() method or custom comparator if
     * ... it was provided
     * @param arr
     * @param comparator - optional comparator providing comparison logic
     */
    private static void bubbleSortGeneric(
            Comparable[] arr, @Nullable Comparator comparator){
        int n = arr.length;
        if(comparator != null){
            for (int i = 0; i < n - 1; i++){
                for (int j = 0; j < n - i - 1; j++){
                    if (comparator.compare(arr[j], arr[j+1]) > 0){
                        Comparable temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++){
                for (int j = 0; j < n - i - 1; j++){
                    if (arr[j].compareTo(arr[j + 1]) > 0){
                        Comparable temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        // int[] arr = {5, 6, 2, 1, 1000, 12, 3, 3};
        // // int[] arr = {1, 2, 3, 5, 6, 1000, 12};
        // // int[] arr = {1, 2, 3, 3, 5, 6, 1000, 12};
        // System.out.println("Before sorting: " + Arrays.toString(arr));
        // bubbleSort(arr);
        // System.out.println("After sorting: " + Arrays.toString(arr));

        // ... example with plain bubble sort
        // Person[] people = {
        //         new Person("Mikas", "Mikaitis", 30),
        //         new Person("Jonas", "Jonaitis", 40),
        //         new Person("Tomas", "Tomaitis", 20),
        //         new Person("Maksas", "Maksaitis", 30)
        // };
        //
        // System.out.print("Before sorting: ");
        // for(int i = 0; i < people.length; i++)
        //     System.out.print(people[i].lastName + " " + people[i].age + "; ");
        // System.out.println();
        //
        // bubbleSort(people);
        //
        // System.out.print("After sorting: ");
        // for(int i = 0; i < people.length; i++)
        //     System.out.print(people[i].lastName + " " + people[i].age + "; ");
        // System.out.println();



        // ... with comparable
        // Human[] a = { new Human("Mikas", "Mikaitis", 30),
        //         new Human("Jonas", "Jonaitis", 40),
        //         new Human("Tomas", "Tomaitis", 20),
        //         new Human("Maksas", "Maksaitis", 30)
        // };

        // Person2[] a = { new Person2("Mikas", "Mikaitis", 30),
        //         new Person2("Jonas", "Jonaitis", 40),
        //         new Person2("Tomas", "Tomaitis", 20),
        //         new Person2("Maksas", "Maksaitis", 30)
        // };

        ErasmusStudent[] a = {
                new ErasmusStudent("Mikas", "Mikaitis", 30, 6),
                new ErasmusStudent("Jonas", "Jonaitis", 40, 5),
                new ErasmusStudent("Tomas", "Tomaitis", 20, 10),
                new ErasmusStudent("Maksas", "Maksaitis", 30, 5)
        };

        System.out.print("Before sorting: ");
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i].lastName + " " + a[i].age + " ");
        System.out.println();

        bubbleSortWithComparable(a);
        // bubbleSortWithComparator(a, new HumanDescendingComparator());
        // bubbleSortWithComparator(a, new HumanAscendingComparator());
        // bubbleSortGeneric(a, null);

        System.out.print("After sorting: ");
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i].lastName + " " + a[i].age + " ");
        System.out.println();
    }
}

class Person {
    String name;
    String lastName;
    int age;

    Person(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}

class Person2 implements Comparable {
    String name;
    String lastName;
    int age;

    Person2(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if(this.age == ((Person2)o).age){
            return 0;
        } else if(this.age > ((Person2)o).age){
            return 1;
        } else {
            return -1;
        }
    }
}

class Human implements Comparable {
    String name;
    String lastName;
    int age;

    Human(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if(this.age == ((Human)o).age)
            return 0;
        else if (this.age > ((Human)o).age)
            return 1;
        else
            return -1;
    }
}

class HumanDescendingComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Human)o2).age - ((Human)o1).age;
    }
}

class HumanAscendingComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(((Human)o1).age == ((Human)o2).age)
            return 0;
        else if (((Human)o1).age > ((Human)o2).age)
            return 1;
        else
            return -1;
    }
}

// Comparison by two fields, not by one
class ErasmusStudent implements Comparable {
    String name;
    String lastName;
    int age;
    int grade;

    ErasmusStudent(String name, String lastName, int age, int grade){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(Object o) {
        if(this.age == ((ErasmusStudent)o).age)
            if(this.grade == ((ErasmusStudent)o).grade)
                return 0;
            else if (this.grade > ((ErasmusStudent)o).grade)
                return 1;
            else
                return -1;
        else if (this.age > ((ErasmusStudent)o).age)
            return 1;
        else
            return -1;
    }
}
