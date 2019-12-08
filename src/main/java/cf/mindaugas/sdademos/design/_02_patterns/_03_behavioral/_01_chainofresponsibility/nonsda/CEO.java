package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

public class CEO extends Handler {

	@Override
	public void handleRequest(Request request) {
		System.out.println("CEOs can approve anything they want");
	}
}
