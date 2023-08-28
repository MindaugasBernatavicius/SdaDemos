package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class _11_CowSyncConcurrCollections {
    public static void arrayListExample(){
        List<String> list = new ArrayList<>();
        list.add("A"); list.add("B"); list.add("c");

        Runnable r1 = () -> System.out.println(list.get(2));
        Runnable r2 = () -> list.add(Integer.toString(1));

        // Runnable r1 = () -> { for (String s : list) System.out.println(s); };
        // Runnable r2 = () -> { for (int i = 0; i < 10; i++) list.add(Integer.toString(1)); };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    public static void copyOnWriteArrayList(){
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("A"); list.add("B"); list.add("c");

        Runnable r1 = () -> { for (String s : list) System.out.println(s); };
        Runnable r2 = () -> { for (int i = 0; i < 10; i++) list.add(Integer.toString(1)); };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    public static void syncedArrayList(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("A"); list.add("B"); list.add("c");

        // Runnable r1 = () -> { for (String s : list) System.out.println(s); };
        // Runnable r2 = () -> { for (int i = 0; i < 10; i++) list.add(Integer.toString(1)); };

        Runnable r1 = () -> {
            synchronized (list) {
                for (String s : list) System.out.println(s);
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 10; i++)
                synchronized (list){
                    list.add(Integer.toString(1));
                }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        // arrayListExample();
        // copyOnWriteArrayList();
        syncedArrayList();
    }
}

