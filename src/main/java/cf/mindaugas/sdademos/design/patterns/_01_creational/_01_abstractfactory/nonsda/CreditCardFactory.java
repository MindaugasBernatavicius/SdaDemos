package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda;

import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda.models.CardType;
import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda.models.CreditCard;
import cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda.models.Validator;

//AbstractFactory
public abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(int creditScore) {
		if(creditScore > 650) {
			return new AmexFactory();
		} else {
			return new VisaFactory();
		}
	}
	
	public abstract CreditCard getCreditCard(CardType cardType);
		
	public abstract Validator getValidator(CardType cardType);
}
