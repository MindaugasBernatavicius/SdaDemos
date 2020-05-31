package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

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

// ... requests that can be fullfilled or passed to successor by each handler
enum RequestType {
	CONFERENCE, PURCHASE;
}

class Request {
	private RequestType requestType;
	private double amount;

	public Request(RequestType requestType, double amount) {
		this.requestType = requestType;
		this.amount = amount;
	}
	public RequestType getRequestType() {
		return requestType;
	}
	public double getAmount() {
		return amount;
	}
}

// abstract handler - establishes the contract
abstract class Handler {
	protected Handler successor;
	public Handler setSuccessor(Handler successor) {
		this.successor = successor;
		// ... if you want a flent and hierachical interface, like such: director.setSuccessor(vicePresident).setSuccessor(ceo);
		// ... then be carefull  not to return "this" here as it would just reset the success for the director
		return successor;
	}
	public abstract void handleRequest(Request request);
}

// ... all the concrete handlers that extend the abstract handler
class CEO extends Handler {
	@Override
	public void handleRequest(Request request) {
		System.out.println("CEOs can approve anything they want");
	}
}

class VP extends Handler {
	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.PURCHASE) {
			if(request.getAmount() < 1500) {
				System.out.println("VPs can approve purchases below 1500");
			} else {
				successor.handleRequest(request);
			}
		}
	}
}

class Director extends Handler {
	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE) {
			System.out.println("Directors can approve conferences");
		} else {
			successor.handleRequest(request);
		}
	}
}
