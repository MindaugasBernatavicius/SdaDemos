package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.sda.example.pizza;

public abstract class Pizza {

    public abstract String getName();

    public abstract int getSize();

    public abstract String getIngredients();

    @Override
    public String toString() {
        return "Pizza= " + this.getName() + ", Size= " + this.getSize() + ", Ingredients= " + this.getIngredients();
    }
}
