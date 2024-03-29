package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda;

import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.BasicPizza;
import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.HamPizza;
import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.MushroomsPizza;
import cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example.Pizza;

public class DecoratorExample {
    public static void main(String[] args) {
        // Pizza pizza = new BasicPizza();
        // pizza.printIngredients();
        // Pizza hamPizza = new HamPizza(pizza);
        // pizza.printIngredients();
        // Pizza mushroomsPizza = new MushroomsPizza(pizza);
        // pizza.printIngredients();
        // Pizza mushroomsPizza = new MushroomsPizza(hamPizza);
        // pizza.printIngredients();

        // Pizza p = new HamPizza(new MushroomsPizza(new BasicPizza()));
        Pizza p = new HamPizza(new BasicPizza());
        p.printIngredients();

        // Pizza seafoodPizza = new SeafoodPizza(new BasicPizza());
        // pizza.printIngredients();
    }
}
