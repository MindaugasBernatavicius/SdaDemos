package cf.mindaugas.sdademos.javaadvanced._08_nestedclasses;

public class NestedClassSimpleExample {
    public static void main(String[] args) {
        // 0. Instance inner class (non-static)
       // Bicycle bicycle = new Bicycle();
       // System.out.println(bicycle.getMaxSpeed()); // Prints 40
       //
       // Bicycle.Wheel wheel = bicycle.new Wheel();
       // wheel.damage();
       // System.out.println(bicycle.getMaxSpeed()); // Prints 20

        // 1. Static inner class
        BicycleWStaticMechanic bicycleWStaticMechanic = new BicycleWStaticMechanic();
        System.out.println(bicycleWStaticMechanic.getMaxSpeed()); // Prints 25
        BicycleWStaticMechanic.Mechanic mechanic = new BicycleWStaticMechanic.Mechanic();
        mechanic.repair(bicycleWStaticMechanic);
        System.out.println(bicycleWStaticMechanic.getMaxSpeed()); // Prints 40
    }
}

class Bicycle {
    private int maxSpeed = 40;
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public class Wheel {
        public void damage() {
            // we can refer to outer class's field
            // (Wheel type object will be created
            // for an Bicycle instance)
            maxSpeed *= 0.5;
        }
    }
}

class BicycleWStaticMechanic {
    private int maxSpeed = 25;
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public static class Mechanic {
        public void repair(BicycleWStaticMechanic bicycle) {
            // nested static class can refer
            // private field of outer class
            bicycle.maxSpeed += 15;
        }
    }
    //    public static void main(String[] args) {
    //        Mechanic mechanic = new Mechanic();
    //    }
}
