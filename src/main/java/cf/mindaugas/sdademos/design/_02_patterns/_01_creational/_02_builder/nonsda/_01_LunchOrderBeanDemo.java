package cf.mindaugas.sdademos.design._02_patterns._01_creational._02_builder.nonsda;

public class _01_LunchOrderBeanDemo {
    public static void main(String[] args) {

        LunchOrderBean lunchOrderBean = new LunchOrderBean();

        // no immutability, no contract of what is a valid lunchOrder (things can be commented out)
        lunchOrderBean.setBread("Wheat");
        // lunchOrderBean.setCondiments("Lettuce");
        // lunchOrderBean.setDressing("Mustard");
        lunchOrderBean.setMeat("Ham");

        System.out.println(lunchOrderBean.getBread());
        System.out.println(lunchOrderBean.getCondiments());
        System.out.println(lunchOrderBean.getDressing());
        System.out.println(lunchOrderBean.getMeat());
    }
}

class LunchOrderBean {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBean() {}

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
    public void setBread(String bread) {
        this.bread = bread;
    }
    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }
    public void setDressing(String dressing) {
        this.dressing = dressing;
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }
}