package cf.mindaugas.sdademos.design.patterns._01_creational._01_abstractfactory.nonsda.models;

//AbstractProduct
public abstract class CreditCard {

	protected int cardNumberLength;
	
	protected int cscNumber;

	public int getCardNumberLength() {
		return cardNumberLength;
	}

	public void setCardNumberLength(int cardNumberLength) {
		this.cardNumberLength = cardNumberLength;
	}

	public int getCscNumber() {
		return cscNumber;
	}

	public void setCscNumber(int cscNumber) {
		this.cscNumber = cscNumber;
	}
	
}
