package cf.mindaugas.sdademos.design._02_patterns._02_structural._01_Decorator.nonsda;

public class DecoratorSandwichDemo {

	public static void main(String args[]) {
		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		System.out.println(sandwich.make());

		// an example of dinamicaly adding additonal properties to an object
        System.out.println(new SaladDecorator(sandwich).make());

	}
}