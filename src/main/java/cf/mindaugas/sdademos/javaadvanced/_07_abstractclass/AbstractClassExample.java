package cf.mindaugas.sdademos.javaadvanced._07_abstractclass;

public class AbstractClassExample {
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle(4, 5);
        System.out.println("Area:" + myRectangle.getArea());

        Circle myCircle = new Circle(4);
        System.out.println("Area:" + myCircle.getArea());
    }
}

abstract class Shape {

    protected int width;

    abstract double getArea();
    abstract double getPerimeter();
}

class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(int i, int i1) {
        this.a = i;
        this.b = i1;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class Circle extends Shape {

    public Circle(int width) {
        this.width = width;
    }

    @Override
    double getArea() {
        return 3.14 * (this.width / 2) * (this.width / 2) ;
    }

    @Override
    double getPerimeter() {
        return 2 * 3.14 * (this.width / 2); // 2ΠR
    }
}
