package cf.mindaugas.sdademos._02_javaadvanced._10_generics;

// Other ways to make your code more generic (generic means - compatible with more types)
class BoxSimple {
    private Object value;
    public BoxSimple(Object obj){
        this.value = obj;
    }
    public Object getValue(){
        return value;
    }
    public Object getValueGeneric(){
        return value;
    }
}

class BoxWithPolymorphism {
    private Vehicle value;
    public BoxWithPolymorphism(Vehicle obj){
        this.value = obj;
    }
    public Vehicle getValue(){
        return value;
    }
}

class BoxWithGenerics<T> {
    private T value;
    public BoxWithGenerics(T obj){
        this.value = obj;
    }
    public T getValue(){
        return value;
    }
}

class BoxWithGenericsWithInterface<T extends Vehicle> {
    private T value;
    public BoxWithGenericsWithInterface(T obj){
        this.value = obj;
        obj.makeNoise();
    }
    public T getValue(){
        return value;
    }
}

class BoxWithGenericsUpperMultiBound<T extends Thing & Vehicle> {
    private T value;
    public BoxWithGenericsUpperMultiBound(T obj){
        this.value = obj;
        obj.makeNoise();
    }
    public T getValue(){
        return value;
    }
}

class VehicleBox extends BoxWithGenerics<Vehicle>{
    public VehicleBox(Vehicle obj) {
        super(obj);
    }
}

public class _02_Generics {
    public static void main(String[] args){
        Car car = new Car();
        Bike bike = new Bike();
        BoxSimple boxWithCar = new BoxSimple(car);
        BoxSimple boxWithBike = new BoxSimple(bike);

        BoxWithPolymorphism boxWithInterfaceWithCar = new BoxWithPolymorphism(car);
        BoxWithPolymorphism boxWithInterfaceWithBike = new BoxWithPolymorphism(bike);

        BoxWithGenerics<Car> boxWithGenericsWithCar = new BoxWithGenerics(car);
        BoxWithGenerics<Bike> boxWithGenericsWithBike = new BoxWithGenerics(bike);

        //System.out.println(boxWithCar.getValue().equals(otherBoxWithCar.getValue()));
        ((Car)boxWithCar.getValue()).makeNoise();
        ((Bike)boxWithBike.getValue()).makeNoise();

        Car otherSportsCar = (Car)boxWithCar.getValueGeneric();
        otherSportsCar.makeNoise();

        ((Vehicle)boxWithCar.getValue()).makeNoise();
        ((Vehicle)boxWithBike.getValue()).makeNoise();

        boxWithInterfaceWithCar.getValue().makeNoise();
        boxWithInterfaceWithBike.getValue().makeNoise();

        boxWithGenericsWithCar.getValue().startEngine();
        boxWithGenericsWithBike.getValue().makeNoise();
    }
}

// ... Classes that define data
class Thing { }

interface Vehicle{
    void makeNoise();
}

class Car extends Thing implements Vehicle{
    public void makeNoise(){
        System.out.println("Wroom wroom");
    }
    public void startEngine(){ }
}

class Bike extends Thing implements Vehicle {
    public void makeNoise(){
        System.out.println("Ding ding");
    }
}
