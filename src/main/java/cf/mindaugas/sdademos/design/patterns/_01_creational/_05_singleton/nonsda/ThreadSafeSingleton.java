package cf.mindaugas.sdademos.design.patterns._01_creational._05_singleton.nonsda;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

//    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
//        if (instance == null) {
//            synchronized (ThreadSafeSingleton.class) {
//                if (instance == null) {
//                    instance = new ThreadSafeSingleton();
//                }
//            }
//        }
//        return instance;
//    }
}