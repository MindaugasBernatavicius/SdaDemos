package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda;

import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda.models.*;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				return new AmexGoldCreditCard();
			case PLATINUM:
				return new AmexPlatinumCreditCard();
			default:
				break;
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				return new AmexGoldValidator();
			case PLATINUM:
				return new AmexPlatinumValidator();
		}
		return null;
	}
}
