package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._01_builder.sda.example;

public class Pizza {

    private final String name;
    private final int size;

    private final boolean isAddChees;
    private final boolean isAddSauce;
    private final boolean isTakeaway;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isAddChees() {
        return isAddChees;
    }

    public boolean isAddSauce() {
        return isAddSauce;
    }

    public boolean isTakeaway() {
        return isTakeaway;
    }

    // Builder pattern only solves problems of building objects
    // ... not problems of their representation. The fact that using
    // ... a builder pattern you will not need to write nulls in ctors
    // ... like toString() or toJson() implementation will not
    // ... return a null for surname. Representation is different
    // ... and builder does not have anything to say about that, so
    // ... see bellow how to not print nulls when doing a toString()
    @Override
    public String toString() {
        return "Pizza= " + this.getName() + ", Size= " + this.getSize()
                + (this.isAddChees ? ", chees" : "")
                + (this.isAddSauce ? ", sauce" : "")
                + (this.isTakeaway ? ", takeaway" : "");
    }

    private Pizza(PizzaBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.isAddChees = builder.isAddChees;
        this.isAddSauce = builder.isAddSauce;
        this.isTakeaway = builder.isTakeaway;
    }

    public static class PizzaBuilder {
        private String name;
        private int size;

        private boolean isAddChees;
        private boolean isAddSauce;
        private boolean isTakeaway;

        public PizzaBuilder(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public PizzaBuilder addChees(boolean isAddChees) {
            this.isAddChees = isAddChees;
            return this;
        }

        public PizzaBuilder addSauce(boolean isAddSauce) {
            this.isAddSauce = isAddSauce;
            return this;
        }

        public PizzaBuilder takeaway(boolean isTakeaway) {
            this.isTakeaway = isTakeaway;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }

    }
}
