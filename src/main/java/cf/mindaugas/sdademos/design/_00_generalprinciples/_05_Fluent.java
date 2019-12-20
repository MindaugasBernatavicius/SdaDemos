package cf.mindaugas.sdademos.design._00_generalprinciples;

public class _05_Fluent {
    public static void main(String[] args) {
        PensionCalculator pc = new PensionCalculator();
        double pension = pc.with().personAge(69).and().workExperience(30).getPension();
        System.out.println("Pension is: " + pension);
    }
}

class PensionCalculator {
    private int age;
    private int workExperience;
    private static final double BASE_PENSION_RATE = 150.0;
    private double ageCoeff;

    public PensionCalculator and(){
        return this;
    }

    public PensionCalculator with(){
        return this;
    }

    public PensionCalculator personAge(int age){
        this.age = age;
        return this;
    }

    public PensionCalculator workExperience(int exp){
        workExperience = exp;
        return this;
    }

    // exercise - make the age multiplier dynamically
    // changeable with fluent interface;

    public double getPension(){
        return BASE_PENSION_RATE
                + (age * 0.95) + workExperience;
    }

//    public double getPension(){
//        return BASE_PENSION_RATE
//                + (age * ageCoeff) + workExperience;
//    }
//
//    public PensionCalculator ageCoefficient(double coeff){
//        ageCoeff = coeff;
//        return this;
//    }
}
