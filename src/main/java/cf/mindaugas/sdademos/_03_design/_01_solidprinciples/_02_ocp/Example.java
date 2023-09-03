package cf.mindaugas.sdademos._03_design._01_solidprinciples._02_ocp;


// This example does not execute any code, it's just structure
public class Example {
}

// 0. We have only Rectangle class and AreaCalculator for that Rectangle
// class Rectangle {
//    public double length;
//    public double width;
// }

// class AreaCalculator {
//    public double calculateRectangleArea(Rectangle rectangle){
//        return rectangle.length * rectangle.width;
//    }
// }

// 1. Adding another shape, requires adding another method to AreaCalculator
// class Circle{
//    public double radius;
// }

class AreaCalculator {
    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }
    // public double calculateCircleArea(Circle circle){
    //     return (22/7) * circle.radius * circle.radius;
    // }
}

///////////////////////////////////////////////
// ..... OCP compliant solution
///////////////////////////////////////////////

// In this design shape interface did not need modifications
// when we extended the capabilities of our app
interface Shape {
    public double calculateArea();
}

class Rectangle implements Shape {
    double length;
    double width;

    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    // private static final double PI = 22/7;
    public double radius;

    public double calculateArea() {
        // DON'T USE MAGIC CONSTANTS, use a named constant (see above)
        return (22 / 7) * radius * radius; // pi * r^2
    }
}


///////////////////////////////////////////////
// ..... WHY DOES THIS NOT VIOLATE SRP?
// ..... Because we can say, that simple objects like mathematical shapes
// ..... have area as an inherent property (derived inherent property from length and width).
// ..... unlike employee calculating his own promotion
///////////////////////////////////////////////

///////////////////////////////////////////////
// ..... another way would be to extend the initial AreaCalculator
// ..... with new functionality. This way we did not change
// ..... AreaCalculator logic, we did not touch it at all.
///////////////////////////////////////////////

class AreaCalculatorWithCircle extends AreaCalculator {
    public double calculateCircleArea(Circle circle) {
        return (22 / 7) * circle.radius * circle.radius;
    }
}


// Question: how about calculation of perimeter?
// Should we add it to a shape interface?
// Should we create another interface?
