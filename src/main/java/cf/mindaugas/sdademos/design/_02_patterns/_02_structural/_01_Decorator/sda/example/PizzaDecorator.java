package cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.sda.example;

public class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void printIngredients() {
        this.pizza.printIngredients();
    }

    @Override
    public void addIngredients(String ingredient) {
        this.pizza.addIngredients(ingredient);
    }
}
