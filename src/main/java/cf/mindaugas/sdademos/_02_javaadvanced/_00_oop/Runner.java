package cf.mindaugas.sdademos._02_javaadvanced._00_oop;

public class Runner {

    // can we access static data from an object (using an object)
    private static String data = "Mindaugas";

    public int add(int i, int j) {
        return i + j;
    }

    public static void main(String[] args) {
        Flight f1 = new Flight();
        f1.setId(12345);
        f1.setPassengers(46);

        // one line construction of objects
        Flight f2 = new Flight(443, 55);

        System.out.println(f1.getId());
        System.out.println(f2.getId());
        System.out.println(f2.getPassengers());

        // in-place initialization
        System.out.println((new Flight(55, 66)).getPassengers());

        Plane p1 = new Plane();

        // calling non-static method, from static context
        Runner ed = new Runner(); // ... we can create an object of the same class inside the class
        System.out.println("Answer from add(): " + ed.add(1, 2));

        // .. can we access static data using an object - yes we can!
        System.out.println(ed.data);

        // Exercise
        // ... Modify Plane class - add constructors, getters and setters
        // ... Add a method called addPassenger() which would increment passengerCount variable
        // ... Create an array of planes, with different data
        // ... Print each planes maxCapacity in a for loop

        Plane p2 = new Plane(100, "White");
        Plane p3 = new Plane(150, "Brown");

        Plane[] planes = {
                new Plane(200, "Black"),
                new Plane(300, "Pink"),
                p2,
                p3
        };

        for (int i = 0; i < planes.length; i++) {
            System.out.println("Plane's [" + i + "] maxCapacity is: "
                    + planes[i].getMaxCapacity());
        }

        // ... what if we had to represent the same situation
        // ... with an array? It would be much messier / dirtier.
        // ... For example, we could not have methods associated
        // ... with the elements in the array.
        String[][] planesArr = {
                {"10", "White", "3"},
                {"15", "Black", "5"},
                {"150", "Brown", "77"},
        };


        System.out.println("Dog's default color: " + new Dog().getColor());

        // - Add verification for all arguments passed to the setters.
        // ... E.g. setWeigth method should not accept values below or equal to 0.
        System.out.println("------------------------------");
        Dog jack = new Dog("Black", 6, 22.0);
        System.out.println(jack.getWeight());
        jack.setWeight(-2);
        System.out.println(jack.getWeight());
        jack.setWeight(21);
        System.out.println("After passing correct value:" + jack.getWeight());
        System.out.println("------------------------------");
    }
}

class Dog {
    private String color;
    private int age;
    private double weight; // ... 0.0

    // constructor that sets default values
    public Dog() {
        this.color = "Black";
        this.age = 1;
    }

    public Dog(String color, int age, double weight) {
        this.color = color;
        this.age = age;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Weight passed was below zero!");
        } else {
            this.weight = weight;
        }
    }
}

class Flight {
    // field initializers
    int id;
    private int passengers;
    private boolean isOverBooked = true; // if left empty it would be false (default is false for boolean)

    // we can call functions on field initializers
    int age = (int) (Math.random() * 100);

    // default constructor
    public Flight() {
    }

    public Flight(int id) {
        this.id = id;
    }

    // constructor with parameters
    public Flight(int id, int passengers) {
        this(id); // calling the Flight(int id) constructor
        this.passengers = passengers;
    }

    public int getId() {
        return this.id; // explicit this
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }


    // If initialization requires some logic (for example, error handling or a for loop to fill a complex array),
    // simple assignment is inadequate. Instance variables can be initialized in constructors,
    // where error handling or other logic can be used. To provide the same capability for class variables,
    // the Java programming language includes static initialization blocks.

    {
        id = (int) (Math.random() * 100);
        System.out.println("Printing from inside the initialization block: " + id);
    }

    // initialization blocks are executed in order of declaration
    {
        id = (int) (Math.random() * 100);
    }
}

class Plane {
    int maxCapacity;
    String color;
    private int passengerCount;

    public void addPassenger() throws Exception {
        // passengerCount = passengerCount + 1;
        // passengerCount += passengerCount;
        if (passengerCount < maxCapacity) {
            passengerCount++;
        } else {
            throw new Exception("Too many passengers!");
        }
    }

    public Plane() {
    }

    public Plane(int maxCapacity, String color) {
        this.maxCapacity = maxCapacity;
        this.color = color;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
