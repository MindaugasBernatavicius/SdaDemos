package cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda;

import cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda.example.BasicPizza;
import cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda.example.HamPizza;
import cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda.example.MushroomsPizza;
import cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda.example.Pizza;

public class DecoratorExample {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        pizza.printIngredients();
        Pizza hamPizza = new HamPizza(pizza);
        pizza.printIngredients();
        Pizza mushroomsPizza = new MushroomsPizza(pizza);
        pizza.printIngredients();

//        Pizza seafoodPizza = new SeafoodPizza(new BasicPizza());
//        pizza.printIngredients();
    }
}
