package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.exercise;

import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.Pizza;
import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.PizzaDecorator;

public class SeafoodPizza extends PizzaDecorator {

    public SeafoodPizza(Pizza pizza) {
        super(pizza);
        super.addIngredients("Seafood");
    }

    @Override
    public void printIngredients() {
        super.printIngredients();
    }
}
