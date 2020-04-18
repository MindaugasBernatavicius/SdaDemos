package cf.mindaugas.sdademos.javaadvanced._02_inheritence._01_protectedVsPrivate;

public class ProtectedVsPrivate {
    public static void main(String[] args) {

    }
}

class Animal {
    protected int legCount = 4; // possible to change from Dog
    // private int legCount = 4; // NOT possible to change from Dog
}

class Dog extends Animal {
    void setLegCountTo7(){
        legCount = 7;
    }
}
