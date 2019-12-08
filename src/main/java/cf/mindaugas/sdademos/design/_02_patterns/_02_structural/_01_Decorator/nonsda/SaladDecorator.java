package cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.nonsda;

public class SaladDecorator extends SandwichDecorator {

	public SaladDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	public String make() {
		return customSandwich.make() + addSalad();
	}

	private String addSalad() {
		return " + salad";
	}
}
