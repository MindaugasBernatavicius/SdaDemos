package cf.mindaugas.sdademos._02_javaadvanced._06_interfaces;

public class SimpleExample {
    public static void main(String[] args) {
        // Invalid code - interface cannot be instantiated
        // Shape myShape = new Shape();

        Rectangle myRectangle = new Rectangle(4, 5);
        System.out.println(myRectangle.getArea());

        Shape myShape = myRectangle;
        // Calling Rectangle#getPerimeter implementation.
        System.out.println(myShape.getPerimeter());

        // prints "Shape: " + myRectangle#toString methods value
        myRectangle.print();
    }
}

interface Shape {
    // public and abstract by default
    double getArea();

    double getPerimeter();

    default void print() {
        System.out.println("Shape: " + this);
    }
}

class Rectangle implements Shape {
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
