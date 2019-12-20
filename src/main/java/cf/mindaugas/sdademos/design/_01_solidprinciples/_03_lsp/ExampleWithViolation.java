package cf.mindaugas.sdademos.design._01_solidprinciples._03_lsp;

public class ExampleWithViolation { }

class Shape {
    private Integer length;
    private Integer width;

    Shape(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    void setLength(Integer length) {
        this.length = length;
    }
    void setWidth(Integer width) {
        this.width = width;
    }
    Integer getArea() {
        return this.length * this.width;
    }
}

class Square extends Shape {

    Square(Integer lengthAndWidth) {
        super(lengthAndWidth, lengthAndWidth);
    }

    @Override
    public void setLength(Integer length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(Integer width) {
        super.setWidth(width);
        super.setLength(width);
    }
}

class Elipsis extends Shape {

    Elipsis(Integer length) {
        super(length, length);
    }

    @Override
    public void setLength(Integer length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(Integer width) {
        super.setWidth(width);
    }

    // getArea() is not overridden making the child not substitutable for parent
    // ... that means we are violating this principle
}
