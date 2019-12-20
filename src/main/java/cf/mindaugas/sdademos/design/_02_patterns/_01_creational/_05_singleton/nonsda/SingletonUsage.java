package cf.mindaugas.sdademos.design._02_patterns._01_creational._05_singleton.nonsda;

import java.util.Scanner;

public class SingletonUsage {

    public static void main(String args[]) {
        // Every day use
        // Runtime singletonRuntime = Runtime.getRuntime();
        // // singletonRuntime.gc();
        // System.out.println(singletonRuntime);
        // Runtime anotherInstance = Runtime.getRuntime();
        // System.out.println(anotherInstance);
        //
        // if(singletonRuntime == anotherInstance) {
        //     System.out.println("They are the same instance");
        // }

        String s1 = "ABC";
        String s2 = "ABC";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

//        System.out.println("test" == "test"); // --> true
//        System.out.println(new String("test") == "test"); // --> false
//        System.out.println(new String("test").equals("test")); // --> true
//
//        Scanner s = new Scanner(System.in);
//        String ss1 = s.nextLine();
//        System.out.println(ss1 == "test"); // --> false
//        System.out.println(ss1.equals("test")); // --> true


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

    private void getSomething(){
        System.out.println("aaa");
    }
}
