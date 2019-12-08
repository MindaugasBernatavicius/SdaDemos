package cf.mindaugas.sdademos.design._02_patterns._01_creational._05_singleton.sda;

public class SingletonExample {
    public static void main(String[] args) {
        Pizza margharita = Pizza.getInstance();
        margharita.name = "Margharita";
        Pizza capriciosa = Pizza.getInstance();
        capriciosa.name = "Capriciosa";
        Pizza fruttidimare = Pizza.getInstance();
        fruttidimare.name = "Frutti di mare";

        System.out.println(margharita);
        System.out.println(capriciosa);
        System.out.println(fruttidimare);

//        Animal dog = Animal.getInstance();
//        Animal cat = Animal.getInstance();
//        cat.type = "Cat";
//        Animal duck = Animal.getInstance();
//        duck.type = "Duck";
//
//        System.out.println(dog);
//        System.out.println(cat);
//        System.out.println(duck);

    }
}


// Example
class Pizza {

    private static Pizza instance = null;

    public String name;

    private Pizza() {
        name = "Margharita";
    }

    public static Pizza getInstance() {
        if (instance == null) {
            instance = new Pizza();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Pizza name: " + name;
    }
}


// Exercise
class Animal {

    private static Animal instance = null;

    public String type;

    private Animal() {
        type = "Dog";
    }

    public static Animal getInstance() {
        if (instance == null) {
            instance = new Animal();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Animal type: " + type;
    }
}


