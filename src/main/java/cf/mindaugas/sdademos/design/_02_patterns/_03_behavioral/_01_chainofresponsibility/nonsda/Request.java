package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public class Request {

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
