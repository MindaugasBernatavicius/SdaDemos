package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ExercisesWithConcurrency {
    public static void example1() throws InterruptedException {
        // 2.
        RClass rClassObj = new RClass(1);
        RClass rClassObj2 = new RClass(10);
        RClass rClassObj3 = new RClass(100);

        // 3., 4.
        Thread t1 = new Thread(rClassObj);
        t1.start();
        Thread t2 = new Thread(rClassObj2);
        t2.start();
        Thread t3 = new Thread(rClassObj3);
        t3.start();

        Thread.sleep(5000);

        t1.interrupt();
        t1.join();

        t2.interrupt();
        t2.join();

        t3.interrupt();
        t3.join();
    }


    // TODO :: this is not finished, just a hint to the students
    public static void example2() throws InterruptedException {

        Thread[] allEmployess = new Thread[3];

        // Thread te1 = new Thread(new EmployeeR("Jonas"));
        // Thread te2 = new Thread(new EmployeeR("Petras"));
        // Thread te3 = new Thread(new EmployeeR("Mindaugas"));

        allEmployess[0] = new Thread(new EmployeeR("Jonas"));
        allEmployess[1] = new Thread(new EmployeeR("Petras"));
        allEmployess[2] = new Thread(new EmployeeR("Mindaugas"));

        // start
        for (int i = 0; i < allEmployess.length; i++) {
            allEmployess[i].start();
        }

        // manage
        int sleepTime = 30000;
        for (int i = 0; i < allEmployess.length; i++) {
            Thread.sleep(sleepTime);
            allEmployess[i].interrupt();
            allEmployess[i].join();
            sleepTime -= 2000;
        }

        System.out.println("Main thread exits!");
    }

    public static void main(String[] args) throws InterruptedException {
        // example1();
        example2();
    }
}

// 0.
class RClass implements Runnable {
    // 6
    private int i;
    // 5.
    public RClass(int i) {
        this.i = i;
    }

    void modifyInt(){
        this.i++;
    }

    @Override
    public void run() {
        // 7.
        while (true){
            try {
                // 1.
                System.out.println("Hello " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // e.printStackTrace();
                break;
            }
        }
    }
}

// 1. *You are the manager. You have 5 employees. Simulate the situation in which each of them comes at a different time to work.
class EmployeeR implements Runnable {

    private String name;

    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10000);
                System.out.println(this.name + " I'm still working!");
            } catch (InterruptedException e) {
                // e.printStackTrace();
                break;
            }
        }
    }

    public EmployeeR(String name) throws InterruptedException {
        Thread.sleep((new Random()).nextInt(1000));
        System.out.println(name + "I came to work at " + LocalDateTime.now());
        this.name = name;
    }
}
