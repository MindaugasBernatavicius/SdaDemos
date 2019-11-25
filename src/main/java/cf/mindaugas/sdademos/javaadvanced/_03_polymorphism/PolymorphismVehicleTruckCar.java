package cf.mindaugas.sdademos.javaadvanced._03_polymorphism;

public class PolymorphismVehicleTruckCar {

    private static void printSpeedLimit(Vehicle vehicle){
        System.out.println(vehicle.getSpeedLimit());
    }

    public static void main(String[] args) {
        // Assigning child type( Car() ) to parent type (Vehicle)
        Vehicle myCar = new Car(320);

        // Creating a polymorphic array
        Vehicle[] garage = {
                new Truck(200),
                new Car(250),
                new Truck(180),
                myCar
        };

        for (Vehicle v : garage) {
            printSpeedLimit(v);
        }

        // ... and passing the object to a method that accepts a supertype / superclass object
        Car myDogCar = new Car(320);
        printSpeedLimit(myDogCar);
    }
}

class Vehicle {
    private int wheelCount;
    private double maxCargoWeight;
    private double horsePower;
    private int speedLimit;

    public Vehicle(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        if(speedLimit < 0){
            System.out.println("Speedlimit can not be below to zero");
        } else {
            this.speedLimit = speedLimit;
        }
    }
}

class Truck extends Vehicle {
    public Truck(int speedLimit) {
        super(speedLimit);
    }
}

class Car extends Vehicle {
    public Car(int speedLimit) {
        super(speedLimit);
    }
}
