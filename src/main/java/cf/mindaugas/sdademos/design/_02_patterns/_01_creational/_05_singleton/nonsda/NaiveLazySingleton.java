package cf.mindaugas.sdademos.design._02_patterns._01_creational._05_singleton.nonsda;

public class NaiveLazySingleton {

    private static NaiveLazySingleton instance;

    private NaiveLazySingleton(){}

    public static NaiveLazySingleton getInstance(){
        if(instance == null){
            instance = new NaiveLazySingleton();
        }
        return instance;
    }
}