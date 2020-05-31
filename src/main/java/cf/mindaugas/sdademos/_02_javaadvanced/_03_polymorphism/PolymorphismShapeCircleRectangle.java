package cf.mindaugas.sdademos._02_javaadvanced._03_polymorphism;

public class PolymorphismShapeCircleRectangle {

    public static double calculatePerimeter(Shape shape){
        if(shape instanceof Circle)
            return 2 * Math.PI * shape.getHeight();
        else
            return 2 * shape.getHeight() + 2 * shape.getWidth();
    }

    public static void main(String[] args) {
        // Assigning to parent type.
        Shape circle = new Circle(10);
        System.out.println(circle.getHeight());

        // Passing objects into methods that accept their supertypes.
        calculatePerimeter(circle);

        // Polymorphic array
        Shape[] shapes = {
                new Circle(12),
                new Rectangle(33, 22)
        };

        for (Shape s : shapes) {
            System.out.println(
                    s.getClass().getName().substring(
                            s.getClass().getName().lastIndexOf(".") + 1) + "'s width: " + s.getWidth());
        }
    }
}

class Shape {
    private int height;
    private int width;

    Shape(int height, int width) {
        this.height = height;
        this.width = width;
    }

    Shape(int height) {
        this.height = height;
        this.width = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

class Circle extends Shape {
    Circle(int height) {
        super(height);
    }
}

class Rectangle extends Shape {
    Rectangle(int height, int width) {
        super(height, width);
    }
}

// ... Second approach to design the classes to solve this problem

class Shape2 {
    private int height;

    public Shape2(int height) {
        this.height = height;
    }

    protected int getHeight() {
        return height;
    }

    public double calculatePerimeter(){
        return 2 * 3.14 * (height / 2);
    }
}

class Circle2 extends Shape2 {
    public Circle2(int height) {
        super(height);
    }
}

class Rectangle2 extends Shape2 {
    private int width;

    public Rectangle2(int height, int width) {
        super(height);
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return this.width * super.getHeight();
    }
}
