package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._03_abstractfactory.nonsda.models;

public class AmexPlatinumValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {

        return false;
    }

}
