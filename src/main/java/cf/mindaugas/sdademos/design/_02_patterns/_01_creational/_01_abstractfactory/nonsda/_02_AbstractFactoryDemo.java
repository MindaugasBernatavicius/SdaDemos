package cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda;


import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda.models.CardType;
import cf.mindaugas.sdademos.design._02_patterns._01_creational._01_abstractfactory.nonsda.models.CreditCard;

public class _02_AbstractFactoryDemo {

	public static void main(String[] args) {

	    // credit score being passed to the .getCreditCardFactory() method
		CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
		CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);
		System.out.println(card.getClass());
		
		abstractFactory = CreditCardFactory.getCreditCardFactory(600);
		CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
		System.out.println(card2.getClass());
	}
}