package cf.mindaugas.sdademos.javaadvanced._17_methodreferences;

import java.util.function.Predicate;

public class _03_MethodReference {
    public static void main(String[] args) {
        Banana banana = new Banana("DarkYellow", 150);
        // Predicate<Banana> isBananaRipe = b -> Banana.isRipe(b);
        Predicate<Banana> isBananaRipe = Banana::isRipe;
        System.out.println(isBananaRipe.test(banana));
    }
}

class Banana {
    private String color;
    private int wightInGramms;

    public Banana(String color, int wightInGramms) {
        this.color = color;
        this.wightInGramms = wightInGramms;
    }

     static boolean isRipe(Banana b){
        return true; // we can have better logic based on objects data
    }
}
