package cf.mindaugas.sdademos.javaadvanced.generics;

interface Vehicle{
    void makeNoise();
}

class Car implements Vehicle{
    public void makeNoise(){
        System.out.println("Wroom wroom");
    }

    public void startEngine(){

    }
}

class Bike implements Vehicle {
    public void makeNoise(){
        System.out.println("Ding ding");
    }
}

class BoxSimple {
    private Object value;

    public BoxSimple(Object obj){
        this.value = obj;
    }

    public Object getValue(){
        return value;
    }

    public<T> T getValueForGeneric(){
        return (T)value;
    }
}

class BoxWithInterface {
    private Vehicle value;
    public BoxWithInterface(Vehicle obj){
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


class VehicleBox extends BoxWithGenerics<Vehicle>{

    public VehicleBox(Vehicle obj) {
        super(obj);
    }
}


public class Generics {


    public static void main(String[] args){
        Car car = new Car();
        Bike bike = new Bike();
        BoxSimple boxWithCar = new BoxSimple(car);
        BoxSimple boxWithBike = new BoxSimple(bike);

        BoxWithInterface boxWithInterfaceWithCar = new BoxWithInterface(car);
        BoxWithInterface boxWithInterfaceWithBike = new BoxWithInterface(bike);

        BoxWithGenerics<Car> boxWithGenericsWithCar = new BoxWithGenerics(car);
        BoxWithGenerics<Bike> boxWithGenericsWithBike = new BoxWithGenerics(bike);

        //System.out.println(boxWithCar.getValue().equals(otherBoxWithCar.getValue()));
        ((Car)boxWithCar.getValue()).makeNoise();
        ((Bike)boxWithBike.getValue()).makeNoise();

        Car otherCar = boxWithCar.getValueForGeneric();
        otherCar.makeNoise();

        ((Vehicle)boxWithCar.getValue()).makeNoise();
        ((Vehicle)boxWithBike.getValue()).makeNoise();

        boxWithInterfaceWithCar.getValue().makeNoise();
        boxWithInterfaceWithBike.getValue().makeNoise();

        boxWithGenericsWithCar.getValue().startEngine();
        boxWithGenericsWithBike.getValue().makeNoise();
    }
}