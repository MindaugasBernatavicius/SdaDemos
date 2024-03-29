package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._10_templatemethod.nonsda;

public class StoreOrder extends OrderTemplate {

    @Override
    public void doCheckout() {
        System.out.println("Ring up items from cart.");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment with Card present");
    }

    @Override
    public void doDelivery() {
        System.out.println("Bag items at counter");
    }

    @Override
    public void doReceipt() {
        System.out.println("Print receipt");
    }
}
