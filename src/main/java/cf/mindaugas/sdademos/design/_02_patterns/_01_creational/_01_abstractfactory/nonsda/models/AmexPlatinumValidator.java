package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda.models;

public class AmexPlatinumValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		
		return false;
	}

}
