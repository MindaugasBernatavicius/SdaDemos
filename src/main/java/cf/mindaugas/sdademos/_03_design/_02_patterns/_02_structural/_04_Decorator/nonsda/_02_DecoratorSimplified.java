package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.nonsda;

public class _02_DecoratorSimplified {
    public static void main(String[] args) {
        // Sandwich sandwich = new SimpleSandwich();
        // Sandwich sandwich = new MeatDecorator(new SimpleSandwich());
        // Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
        // System.out.println(sandwich.make());

        // an example of dinamicaly adding additonal properties to an object
        // System.out.println(new SaladDecorator(sandwich).make());

        Sandwich sandwich = new SimpleSandwich();
        System.out.println(new SaladDecorator(new SaladDecorator(sandwich)).make());
    }
}

interface Sandwich {
    public String make();
}

class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}

abstract class SandwichDecorator implements Sandwich {
    protected Sandwich customSandwich;
    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }
    public String make() {
        return customSandwich.make();
    }
}

class SaladDecorator extends SandwichDecorator {
    public SaladDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }
    public String make() {
        return customSandwich.make() + addSalad();
    }
    private String addSalad() {
        return " + salad";
    }
}

class MeatDecorator extends SandwichDecorator {
    public MeatDecorator(Sandwich customSandwich) { super(customSandwich); }
    public String make() {
        return customSandwich.make() + addMeat();
    }
    private String addMeat() {
        return " + turkey";
    }
}

class DressingDecorator extends SandwichDecorator {
    public DressingDecorator(Sandwich customSandwich) { super(customSandwich); }
    public String make() {
        return customSandwich.make() + addDressing();
    }
    private String addDressing() {
        return " + mustard";
    }
}
