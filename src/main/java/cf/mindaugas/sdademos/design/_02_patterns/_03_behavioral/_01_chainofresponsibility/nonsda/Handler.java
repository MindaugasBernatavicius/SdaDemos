package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public abstract class Handler {

	protected Handler successor;
	
	public Handler setSuccessor(Handler successor) {
		this.successor = successor;
		// ... if you want a flent and hierachical interface, like such: director.setSuccessor(vicePresident).setSuccessor(ceo);
		// ... then be carefull  not to return "this" here as it would just reset the success for the director
		return successor;
	}
	
	public abstract void handleRequest(Request request);
}
