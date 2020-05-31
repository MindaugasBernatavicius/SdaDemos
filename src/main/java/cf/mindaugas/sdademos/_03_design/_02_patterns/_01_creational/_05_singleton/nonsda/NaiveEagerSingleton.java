package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._05_singleton.nonsda;

public class NaiveEagerSingleton {

    private static NaiveEagerSingleton instance = new NaiveEagerSingleton();
    // private static final NaiveEagerSingleton instance = new NaiveEagerSingleton();

    private String property;

    //private constructor to avoid client applications to use constructor
    private NaiveEagerSingleton(){}

    public static NaiveEagerSingleton getInstance(){
        return instance;
    }

    public void setProperty(String prop) {
        this.property = prop;
    }

    public String getProperty() {
        return property;
    }
}
