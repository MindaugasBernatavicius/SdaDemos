package cf.mindaugas.sdademos.javaadvanced._02_inheritence._00_vehiclecarbike;

public class NoInheritence {
    public static void main(String[] args) {
        Truck t = new Truck(200);
        System.out.println("Speed limit for Truck: " + t.getSpeedLimit());

        Car c = new Car(250);
        System.out.println("Speed limit for Car: " + c.getSpeedLimit());
    }
}

class Truck {
    private int wheelCount;
    private double maxCargoWeight;
    private double horsePower;
    private int speedLimit;

    public Truck(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }
}

class Car {
    private int wheelCount;
    private double maxCargoWeight;
    private double horsePower;
    private int speedLimit;

    public Car(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }
}
