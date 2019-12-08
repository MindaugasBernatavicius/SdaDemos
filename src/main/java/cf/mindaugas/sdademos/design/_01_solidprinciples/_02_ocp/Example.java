package cf.mindaugas.sdademos.design._01_solidprinciples._02_ocp;

public class Example { }

// 0. We have only Rectangle class and AreaCalculator for that Rectangle
//class Rectangle{
//    public double length;
//    public double width;
//}
//
//class AreaCalculator {
//    public double calculateRectangleArea(Rectangle rectangle){
//        return rectangle.length * rectangle.width;
//    }
//}
//
//// 1. Adding another shape, requires adding another method to AreaCalculator
//class Circle{
//    public double radius;
//}

//class AreaCalculator {
//    public double calculateRectangleArea(Rectangle rectangle){
//        return rectangle.length * rectangle.width;
//    }
//    public double calculateCircleArea(Circle circle){
//        return (22/7) * circle.radius * circle.radius;
//    }
//}

///////////////////////////////////////////////

// In this design shape interface did not need modifications
// when we extended the capabilities of our app
interface Shape{
    public double calculateArea();
}

class Rectangle implements Shape{
    double length;
    double width;
    public double calculateArea(){
        return length * width;
    }
}

class Circle implements Shape{
    public double radius;
    public double calculateArea(){
        return (22/7) * radius * radius; // pi * r^2
    }
}

// Question: how about calculation of perimeter?
// Should we add it to a shape interface?
// Should we create another interface?