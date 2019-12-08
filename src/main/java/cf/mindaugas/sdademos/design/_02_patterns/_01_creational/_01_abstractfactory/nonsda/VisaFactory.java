package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda;


import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda.models.*;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
			case GOLD:
				return new VisaGoldCreditCard();
	
			case PLATINUM:
				return new VisaBlackCreditCard();
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		return new VisaValidator();
	}

}
