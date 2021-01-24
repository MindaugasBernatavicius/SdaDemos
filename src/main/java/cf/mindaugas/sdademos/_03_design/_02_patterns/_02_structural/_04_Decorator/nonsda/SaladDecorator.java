package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.nonsda;

public class SaladDecorator extends SandwichDecorator {

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
