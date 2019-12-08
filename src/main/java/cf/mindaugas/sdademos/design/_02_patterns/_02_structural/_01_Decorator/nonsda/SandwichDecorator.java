package cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.nonsda;

public abstract class SandwichDecorator implements Sandwich {

	protected Sandwich customSandwich;

	public SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	public String make() {
		return customSandwich.make();
	}
	
}
