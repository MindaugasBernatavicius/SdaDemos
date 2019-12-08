package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._04_templatemethod.nonsda;

public class _02_TemplateDemo {

	public static void main(String[] args) {
		System.out.println("Web Order:");
		
		OrderTemplate webOrder = new WebOrder();
		webOrder.processOrder();
		
		System.out.println("\nStore Order:");
		
		OrderTemplate storeOrder = new StoreOrder();
		storeOrder.processOrder();
	}
}
