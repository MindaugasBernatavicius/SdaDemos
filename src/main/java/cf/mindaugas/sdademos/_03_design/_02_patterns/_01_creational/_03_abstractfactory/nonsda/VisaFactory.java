package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.nonsda;


import cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.nonsda.models.*;

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
