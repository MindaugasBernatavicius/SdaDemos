package cf.mindaugas.sdademos._02_javaadvanced._02_inheritence._00_vehiclecarbike;

public class ExampleWithInheritence {
    public static void main(String[] args) {
        Truck2 t = new Truck2(200);
        System.out.println("Speed limit for Truck: " + t.getSpeedLimit());

        Car2 c = new Car2(250);
        System.out.println("Speed limit for Car: " + c.getSpeedLimit());

        c.setSpeedLimit(0);
        System.out.println("Speed limit for Car: " + c.getSpeedLimit());
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
        if (speedLimit < 0) {
            System.out.println("Speedlimit can not be below to zero");
        } else {
            this.speedLimit = speedLimit;
        }
    }
}

class Truck2 extends Vehicle {
    public Truck2(int speedLimit) {
        super(speedLimit);
    }
}

class Car2 extends Vehicle {
    public Car2(int speedLimit) {
        super(speedLimit);
    }
}
