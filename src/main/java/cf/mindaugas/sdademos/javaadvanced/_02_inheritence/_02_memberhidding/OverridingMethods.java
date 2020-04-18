package cf.mindaugas.sdademos.javaadvanced._02_inheritence._02_memberhidding;

public class OverridingMethods {

    public static void main(String[] args) {
        // System.out.println(new Animal("Lion", 4));
        System.out.println(new Lion(465342, "Simba"));
    }
}

class Animal {
    private String kind;
    private int legCount;
    private boolean furry; // compare primitive vs. wrapper type behavior in this situation
    // private Boolean furry;

    public Animal(String kind, int legCount) {
        this.kind = kind;
        this.legCount = legCount;
    }

    public Animal(String kind, int legCount, boolean hasFur) {
        this(kind, legCount);
        this.furry = hasFur;
    }

    // public boolean isFurry() {
    //     if(furry == null)
    //         return false;
    //     else
    //         return furry;
    // }

    @Override
    public String toString() {
        return "Animal{" +
                "kind='" + kind + '\'' +
                ", legCount=" + legCount +
                ", furry=" + furry +
                '}';
    }
}

class Lion extends Animal {
    private int id;
    private String name;

    public Lion(int id, String name) {
        super("Lion", 4);
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return '{' +
                    "name=" + name +
                    ", id=" + id +
                    ", info=" + super.toString() +
                '}';
    }
}
