package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.nonsda;

public abstract class SandwichDecorator implements Sandwich {

	protected Sandwich customSandwich;

	public SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	public String make() {
		return customSandwich.make();
	}
	
}
