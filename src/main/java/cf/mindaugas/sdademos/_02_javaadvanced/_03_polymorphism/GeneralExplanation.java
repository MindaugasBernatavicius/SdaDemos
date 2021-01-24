package cf.mindaugas.sdademos._02_javaadvanced._03_polymorphism;

public class GeneralExplanation {
    public static void main(String[] args) {
        // polymorphic array
        Vehicle2[] garage = { new Vehicle2(), new Car2(), new Train2() };

        // polymorphic function
        printSpeedLimit(new Train2());
    }
    private static void printSpeedLimit(Vehicle2 vehicle) {
        System.out.println(vehicle);
    }
}

class Vehicle2 {}
class Train2 extends Vehicle2 {}
class Car2 extends Vehicle2 {}

//  Vehicle (tėvinė)
//   /   \
// Car Train (vaikinės)