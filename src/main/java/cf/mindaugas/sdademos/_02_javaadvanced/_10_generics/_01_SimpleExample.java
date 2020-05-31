package cf.mindaugas.sdademos._02_javaadvanced._10_generics;

public class _01_SimpleExample {
    public static void main(String[] args) {
        Truck car = new Truck();
        Moped moped = new Moped();

        // new GenericBox<Car>(car) is valid as well, but there
        // is no need to put the parametrized type again in the diamonds

        GenericBox<Moped> boxWithACarInIt = new GenericBox<>(moped);
        GenericBox<Truck> boxWithATruckInIt = new GenericBox<>(car);
        GenericBox<String> bs = new GenericBox<>("A");

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
    // public String getItem --> public T getItem()
}

class Truck {
    private String explosionSound = "BOOOOM!";
    public Truck() { }
    public void crash(){
        System.out.println(explosionSound);
    }
}

class Moped { }


