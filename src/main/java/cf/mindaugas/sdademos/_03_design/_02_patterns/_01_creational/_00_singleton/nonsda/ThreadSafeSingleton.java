package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._00_singleton.nonsda;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
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
