package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public class Director extends Handler {

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE) {
			System.out.println("Directors can approve conferences");
		} else {
			successor.handleRequest(request);
		}
	}
}
