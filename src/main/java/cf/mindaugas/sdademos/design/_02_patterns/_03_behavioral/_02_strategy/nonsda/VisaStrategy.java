package cf.mindaugas.sdademos.design._02_patterns._03_behavioral._02_strategy.nonsda;

public class VisaStrategy extends ValidationStrategy {

	@Override
	public boolean isValid(CreditCard creditCard) {
		boolean isValid = true;
		
		isValid = creditCard.getNumber().startsWith("4");
		
		if(isValid) {
			isValid = creditCard.getNumber().length() == 16;
		}

		// if(isValid) {
		// 	isValid = creditCard.getDate() > ;
		// }
		
		if(isValid) {
			isValid = passesLuhn(creditCard.getNumber());
		}
		
		return isValid;
	}

}
