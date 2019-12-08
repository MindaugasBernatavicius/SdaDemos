package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public class _02_ChainOfResponsibilityDemo {

	public static void main(String[] args) {
		Director bryan = new Director();
		VP crystal = new VP();
		CEO jeff = new CEO();

		// ... handlers are added at the client level, we could change that but at cost of flexibility
        // ... reimplemented in the spirit of fluent api principle - take note that the order of binding the succesors matters.
		bryan.setSuccessor(crystal)
				.setSuccessor(jeff);
		
		Request request = new Request(RequestType.CONFERENCE, 500);
		bryan.handleRequest(request);

		request = new Request(RequestType.PURCHASE, 500);
		bryan.handleRequest(request);

		request = new Request(RequestType.PURCHASE, 1000);
		bryan.handleRequest(request); // or we can use crystal or jeff

		// most importantly for Chain or responsibility
		request = new Request(RequestType.PURCHASE, 2000);
		bryan.handleRequest(request);
	}
}
