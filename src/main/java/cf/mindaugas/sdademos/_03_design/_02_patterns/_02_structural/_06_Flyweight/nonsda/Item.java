package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._06_Flyweight.nonsda;

//Instances of Item will be the Flyweights
class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
