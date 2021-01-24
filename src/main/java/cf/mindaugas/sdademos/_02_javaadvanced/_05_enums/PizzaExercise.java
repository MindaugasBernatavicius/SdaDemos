package cf.mindaugas.sdademos._02_javaadvanced._05_enums;

public class PizzaExercise {
    public static void main(String[] args) {
        Pizza p = new Pizza(Size.XL);
        System.out.println(p.getDeliveryTime() + " min");
    }
}

class Pizza {
    private Size size;

    public Pizza(Size size) {
        this.size = size;
    }

    public int getDeliveryTime() {
        return size.getDeliverTime();
    }
}

enum Size {
    S(5),
    M(10),
    L(15),
    XL(20);

    private int time;

    Size(int time) {
        this.time = time;
    }

    int getDeliverTime() {
        return this.time;
    }
}
