package cf.mindaugas.sdademos.javaadvanced._00_oop._02_static;

public class StaticVsInstanceVariablesAndMethods {
    public static void main(String[] args) {
        // HumanBeing mindaugas = new HumanBeing("Mindaugas");
        // HumanBeing jonas = new HumanBeing("Jonas");
        //
        // System.out.println(mindaugas.name);
        // System.out.println(mindaugas.legCount);
        // mindaugas.changeLegCount(5);
        // System.out.println(jonas.legCount); // jonas' leg count change as well!

        // static methods don't require creating objects to be used
        System.out.println(HumanBeing.classLegCount());
        // static fields belong to the class and are the same for all object created from that class
        System.out.println(HumanBeing.legCount);
    }
}

class HumanBeing {
    static int legCount = 2;
    String name;

    public HumanBeing(String name) {
        this.name = name;
    }

    public void changeLegCount(int legC){
        legCount = legC;
    }

    static int classLegCount(){
        return legCount;
    }
}
