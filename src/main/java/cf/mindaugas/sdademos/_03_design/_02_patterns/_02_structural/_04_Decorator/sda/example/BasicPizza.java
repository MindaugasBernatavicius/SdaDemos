package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.sda.example;

import java.util.ArrayList;

public final class BasicPizza implements Pizza {
    ArrayList<String> ingredients;

    public BasicPizza(){
        ingredients = new ArrayList<>();
        addIngredients("Pizza dough");
        addIngredients("Tomato Sauce");
        addIngredients("Cheese");
    }

    @Override
    public void printIngredients() {
        System.out.println("Pizza: "
                + String.join(", ", ingredients));
    }

    @Override
    public void addIngredients(String ingredient) {
        ingredients.add(ingredient);
    }
}
