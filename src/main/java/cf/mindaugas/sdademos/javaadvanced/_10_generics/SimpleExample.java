package cf.mindaugas.sdademos.javaadvanced._10_generics;

public class SimpleExample {
    public static void main(String[] args) {
        Car2 car = new Car2();
        Car truck = new Car();
        // new GenericBox<Car>(car) is valid as well, but there
        // is no need to put the parametrized type again
        // in the diamonds
        GenericBox<Car> boxWithACarInIt = new GenericBox<>(truck);
        GenericBox<Car2> boxWithATruckInIt = new GenericBox<>(car);

        boxWithATruckInIt.getItem().crash();
    }
}

class GenericBox<T> {
    private T item;
    public GenericBox(T item) {
        this.item = item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}

class Car2 {
    private String explosionSound = "BOOOOM!";

    public Car2() { }

    public void crash(){
        System.out.println(explosionSound);
    }
}


