package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._06_Flyweight.nonsda;

public class Order {
    private final int orderNumber;
    private final Item item;

    Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    void processOrder() {
        System.out.println("Ordering " + item + " for order number " + orderNumber);
    }
}
