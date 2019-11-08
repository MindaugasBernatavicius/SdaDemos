package cf.mindaugas.sdademos.javaadvanced._00_oop;

public class Runner {

    public static void main(String[] args) {


        System.out.println(new Person().age);
        System.out.println(new Flight().number);
    }
}

class Flight {
    int number;

    {
        number = (int)(Math.random() * 100);
        System.out.println("Printing from inside the initialization block: " + number);
    }

    {
        number = (int)(Math.random() * 100);
    }
}
