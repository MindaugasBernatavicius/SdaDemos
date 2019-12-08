package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.exercise.pizza;

import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza.Pizza;

public class FruttiDiMare extends Pizza {

    private final int size;

    public FruttiDiMare(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return "Frutti di Mare";
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getIngredients() {
        return "Chees, Tomato Sauce, Seafood";
    }
}
