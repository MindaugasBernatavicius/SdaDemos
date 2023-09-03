package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._00_singleton.nonsda;

public class SingletonUsage {

    public static void main(String[] args) {
        // // 0. Every day use
        // Runtime singletonRuntime = Runtime.getRuntime();
        // // singletonRuntime.gc();
        // System.out.println(singletonRuntime);
        //
        // Runtime anotherInstance = Runtime.getRuntime();
        // System.out.println(anotherInstance);
        //
        // if(singletonRuntime == anotherInstance) {
        //     System.out.println("They are the same instance");
        // }

        // 1. Every day use
        String s1 = "ABC";
        String s2 = "ABC";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        // ... string interning (...remember, strings in Java are immutable)

        // System.out.println("test" == "test"); // --> true
        // System.out.println(new String("test") == "test"); // --> false
        // System.out.println(new String("test").equals("test")); // --> true
        //
        // Scanner s = new Scanner(System.in);
        // String ss1 = s.nextLine();
        // System.out.println(ss1 == "test"); // --> false
        // System.out.println(ss1.equals("test")); // --> true


//        //
//        NaiveEagerSingleton naiveEagerSingleton = NaiveEagerSingleton.getInstance();
//        System.out.println(naiveEagerSingleton);
//
//        NaiveEagerSingleton naiveEagerSingleton2 = NaiveEagerSingleton.getInstance();
//        System.out.println(naiveEagerSingleton2);
//
//        // constructor is private so we can't call it
//        // NaiveEagerSingleton naiveEagerSingleton3 = new NaiveEagerSingleton();
//
//        // Demonstrating the ability of creating an object of the class inside the class itself
//        SingletonUsage su = new SingletonUsage();
//        su.getSomething();
//
//        naiveEagerSingleton.setProperty("Property-value");
//        System.out.println(naiveEagerSingleton2.getProperty());
    }

    private void getSomething() {
        System.out.println("aaa");
    }
}
