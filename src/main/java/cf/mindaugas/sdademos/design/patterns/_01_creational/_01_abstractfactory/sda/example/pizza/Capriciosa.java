package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.sda.example.pizza;

public class Capriciosa extends Pizza {

    private final int size;

    public Capriciosa(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return "Capriciosa";
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getIngredients() {
        return "Chees, Tomato Sauce, Ham, Mushrooms";
    }
}
