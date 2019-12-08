package cf.mindaugas.sdademos.design._01_solidprinciples._03_lsp;

public class ExampleIllustratingThePrinciple {
}

// Bad ....
//class Vehicle {
//    String name;
//    Double speed;
//    Engine engine;
//
//    void startEngine() {
//        this.engine.setState(Engine.State.ON);
//    }
//}
//
//class Car extends Vehicle  {
//    // a car is a vehicle and has engine,
//    // so it makes sense if we provide
//    // some implementation of startEngine()
//    // specific to the car
//    @Override
//    void startEngine() {}
//}
//
//class Bicycle extends Vehicle  {
//    @Override
//    void startEngine() {} // bicycle, does not have an engine, so it does not make sense!
//}
//
//
//class Engine {
//    State state;
//    enum State { ON, OFF }
//    public State getState() {
//        return state;
//    }
//    public void setState(State state) {
//        this.state = state;
//    }
//}

// Better ...
abstract class Vehicle {
    String name;
    Double speed;
}

abstract class EnginedVehicle extends Vehicle {
    Engine engine;
    abstract void startEngine();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

class Car extends EnginedVehicle  {
    @Override
    void startEngine() {}
}

class Bicycle extends Vehicle  { }

class Engine {
    State state;
    enum State { ON, OFF }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}

// Another way ...

// ... how would you solve the case where we would have Vehicles w/o wheels?
// ... would you create Wheeled Vehicle  abstract class or an interface?