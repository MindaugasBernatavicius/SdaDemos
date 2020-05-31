package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example;

public class MushroomsPizza extends PizzaDecorator {
    public MushroomsPizza(Pizza pizza) {
        super(pizza);
        super.addIngredients("Mushrooms");
    }

    @Override
    public void printIngredients() {
        super.printIngredients();
    }
}
