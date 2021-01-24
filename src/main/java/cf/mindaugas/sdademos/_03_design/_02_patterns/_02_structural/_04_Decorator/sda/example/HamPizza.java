package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example;

public class HamPizza extends PizzaDecorator {
    public HamPizza(Pizza pizza) {
        super(pizza);
        super.addIngredients("Ham");
    }

    @Override
    public void printIngredients() {
        super.printIngredients();
    }
}
