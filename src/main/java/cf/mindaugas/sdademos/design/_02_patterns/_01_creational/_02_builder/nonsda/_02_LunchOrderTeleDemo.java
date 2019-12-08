package cf.mindaugas.sdademos.design._02_patterns._01_creational._02_builder.nonsda;

public class _02_LunchOrderTeleDemo {

    public static void main(String args[]) {

        LunchOrderTele lunchOrderTele = new LunchOrderTele(
                "Wheat", "Lettuce", "Mustard", "Ham");

        // lunchOrderTele.setBread("Wheat");
        // lunchOrderTele.setCondiments("Lettuce");
        // lunchOrderTele.setDressing("Mustard");
        // lunchOrderTele.setMeat("Ham");

        System.out.println(lunchOrderTele.getBread());
        System.out.println(lunchOrderTele.getCondiments());
        System.out.println(lunchOrderTele.getDressing());
        System.out.println(lunchOrderTele.getMeat());
    }

}

class LunchOrderTele {

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    // What if I'm eating paleo and I don't want meat?
    // This is immutable, but we need different constructors for everything

    public LunchOrderTele (String bread) {
        this.bread = bread;
    }

    public LunchOrderTele (String bread, String condiments) {
        this(bread);
        this.condiments = condiments;
    }

    public LunchOrderTele (String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public LunchOrderTele (String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
