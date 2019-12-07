package cf.mindaugas.sdademos.design.generalprinciples;

public class _05_Fluent {
    public static void main(String[] args) {
        PersionCalculator pc = new PersionCalculator();
        double pension = pc.with().personAge(69).and().workExperience(30).getPension();
        System.out.println("Pension is: " + pension);
    }
}

class PersionCalculator {
    private int age;
    private int workExperience;
    private static final double BASE_PENSION_RATE = 150.0;

    public PersionCalculator and(){
        return this;
    }

    public PersionCalculator with(){
        return this;
    }

    public PersionCalculator personAge(int age){
        this.age = age;
        return this;
    }

    public PersionCalculator workExperience(int exp){
        workExperience = exp;
        return this;
    }

    // exercise - make the age multiplier dynamically changeable with fluent interface;

    public double getPension(){
        return BASE_PENSION_RATE + age * 0.95 + workExperience;
    }
}