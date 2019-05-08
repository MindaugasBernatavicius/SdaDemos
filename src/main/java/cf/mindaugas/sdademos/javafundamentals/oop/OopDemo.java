package cf.mindaugas.sdademos.javafundamentals.oop;

public class OopDemo {
    public static void main(String[] args) {
        // Car car1 = new Car(4, 5, 306);
        // Car car2 = new Car(5, 77, 306);
        Engine bmwM3engine = new Engine(340, 3.2);
        Car car3 = new Car(4, 8, bmwM3engine);

        System.out.println(car3.getHorsePower());
        car3.setHorsePower(560);
        System.out.println(car3.getHorsePower());

        // static
        Car.seatCount = 4;
    }
}

class Engine {
    int horsepower;
    double displacement;

    public Engine(int hp, double displ){
        this.horsepower = hp;
        this.displacement = displ;
    }
}

class Car {
    private int numOfWheels;
    public static int seatCount;
    private Engine engine;

    public Car(int numOfWheels, int seatCount, Engine engine) {
        this.numOfWheels = numOfWheels;
        this.seatCount = seatCount;
        this.engine = engine;
    }

    public int getHorsePower() {
        // obtain the power from the engine, not from the car object
        System.out.println(engine.horsepower);
        return engine.horsepower;
    }

    public void setHorsePower(int horsePower) {
        // set the power directly to the engine, not using the car object
        engine.horsepower = horsePower;
    }
}