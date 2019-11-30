package cf.mindaugas.sdademos.javaadvanced._10_generics;

public class DynamicArray {
    public static void main(String args[]) {

        // 0. Just a simple dynamic array
        DynamicPersonArray dArr = new DynamicPersonArray(2);
        dArr.add(new Person("Mindaugas", "M"));
        dArr.add(new Person("Jonas", "J"));
        dArr.add(new Person("Antanas", "A"));

        for(int i = 0; i < dArr.length(); i++)
            System.out.print("{" + dArr.getAt(i).getInitials() + "} ");
        System.out.println();


        // 1. A Generic Dynamic array with no type safety
        DynamicGenericArrayWithObject dOArr = new DynamicGenericArrayWithObject(2);
        // dOArr.add("Mindaugas"); // --> we are not prevented from adding incompatible types!
        dOArr.add(new Person("Mindaugas", "M"));
        dOArr.add(new Person("Jonas", "J"));
        dOArr.add(new Person("Antanas", "A"));

        for(int i = 0; i < dOArr.length(); i++)
            System.out.print("{" + ((Person)dOArr.getAt(i)).getInitials() + "} ");
        System.out.println();


        // 2. A Generic Dynamic array with type safety
        DynamicGenericArray<Person> dGArr = new DynamicGenericArray<>(2);
        dGArr.add(new Person("Mindaugas", "M"));
        dGArr.add(new Person("Jonas", "J"));
        dGArr.add(new Person("Antanas", "A"));
        // dGArr.add("Mindaugas"); --> if we try to add something like this, we are not allowed

        // ... need toString() in the DynamicGenericArray class for this to work
        // System.out.println(Arrays.toString(dGArr));
        for(int i = 0; i < dGArr.length(); i++)
            System.out.print("{" + dGArr.getAt(i).getInitials() + "} ");
        System.out.println();
    }
}

class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials(){
        return (this.name.substring(0,1) + this.surname.substring(0,1)).toUpperCase();
    }
}

// ... boilerplate - we implement a dynamic array for chars only,
// ... if we wanted to have a dynamic array for other types we would need to
// ... re-implement it again and again
class DynamicPersonArray {
    private int currentIdx;
    private Person[] array;

    public DynamicPersonArray(int initialSize){
        array = new Person[initialSize];
    }

    public void add(Person c){
        // create a new array and assign to the name of the old one
        if(currentIdx == array.length){
            Person[] tmpArray = new Person[array.length * 2];
            for(int i = 0; i < array.length; i++)
                tmpArray[i] = array[i];
            array = tmpArray;
            tmpArray = null;
        }

        array[currentIdx++] = c; // ... then add an element
    }

    public Person getAt(int idx){
        return array[idx];
    }

    public int length(){
        return currentIdx;
    }
}

// ... no type safety, but more DRY code
class DynamicGenericArrayWithObject{
    private int currentIdx;
    private Object[] array;

    public DynamicGenericArrayWithObject(int initialSize){
        array = new Object[initialSize];
    }

    public void add(Object c){
        // create a new array and assign to the name of the old one
        if(currentIdx == array.length){
            Object[] tmpArray = new Object[array.length * 2];
            for(int i = 0; i < array.length; i++)
                tmpArray[i] = array[i];
            array = tmpArray;
            tmpArray = null;
        }

        array[currentIdx++] = c; // ... then add an element
    }

    public Object getAt(int idx){
        return array[idx];
    }

    public int length(){
        return currentIdx;
    }
}

// ... best from both worlds - type safety and generality (no need for repetition).
class DynamicGenericArray<T> {
    private int currentIdx;
    private T[] array;

    public DynamicGenericArray(int initialSize){
        array = (T[]) new Object[initialSize];
    }

    public void add(T c){
        // create a new array and assign to the name of the old one
        if(currentIdx == array.length){
            T[] tmpArray = (T[]) new Object[array.length * 2];
            for(int i = 0; i < array.length; i++)
                tmpArray[i] = array[i];
            array = tmpArray;
            tmpArray = null;
        }

        array[currentIdx++] = c; // ... then add an element
    }

    public T getAt(int idx){
        return array[idx];
    }

    public int length(){
        return currentIdx;
    }
}