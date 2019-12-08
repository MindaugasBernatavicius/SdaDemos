package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public class VP extends Handler {

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
