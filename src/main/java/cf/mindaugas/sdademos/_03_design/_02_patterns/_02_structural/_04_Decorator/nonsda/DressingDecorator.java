package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.nonsda;

public class DressingDecorator extends SandwichDecorator {

	public DressingDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	public String make() {
		return customSandwich.make() + addDressing();
	}
	
	private String addDressing() {
		return " + mustard";
	}
	
}
