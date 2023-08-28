package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;


// TASK 39. Write a program that will solve the problem below.
//     There is a system that stores current results in competitions. Many screens read the current results, while
//     several sensors update these results. Write a program that allows continuous reading of data through many
//     screens (threads) and updating data by many sensors (threads).
//
//     To update results, the sensor must provide current results along with new ones. The system then verifies that
//     the sensor has current data and updates the data. If the system data has changed during this time, the sensor's
//     data update is rejected.
//
//     For simplicity, you can assume that the sensor is reading data, waiting a random amount of time, and
//     increasing the data by a random value.

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class _13_Exercise39WithStringBuilderAsSharedState {
    public static void startThreads(Thread... ts){
        for(var t : ts) t.start();
    }

    public static void joinThreads(Thread... ts) throws InterruptedException { for(var t : ts) t.join(); }

    public static void main(String[] args) throws InterruptedException {
        // StringBuffer is thread-safe and synchronized whereas StringBuilder is not,
        // ... see: https://www.digitalocean.com/community/tutorials/string-vs-stringbuffer-vs-stringbuilder
        var result = new StringBuffer("0:0");

        var sc1 = new Screen("sc1", result);
        var sc2 = new Screen("sc1", result);

        var snsr1 = new Sensor("snsr1", result);
        var snsr2 = new Sensor("snsr2", result);
        var snsr3 = new Sensor("snsr3", result);

        startThreads(sc1, sc2, snsr1, snsr2, snsr3);
        joinThreads(snsr1, snsr2, snsr3, sc1, sc2); // notice that reading threads are joined later than writers
    }
}

@RequiredArgsConstructor
class Screen extends Thread {
    @NonNull private String name;
    @NonNull private StringBuffer actualResult;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(5);
                System.out.println(name + "::" + actualResult);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

@RequiredArgsConstructor
class Sensor extends Thread {
    @NonNull private String name;
    @NonNull private final StringBuffer actualResult;
    private String lastSeenResult;

    @Override
    public void run() {
        var min = 10;
        var max = 100;
        try {
            for (int i = 0; i < 3; i++) {
                // Thread.sleep(0);
                sleep((int)((Math.random() * (max - min)) + min));
                synchronized(actualResult) {
                    var res1 = Integer.valueOf(actualResult.charAt(0));
                    var res2 = Integer.valueOf(actualResult.charAt(2));
                    actualResult.setCharAt(0, (char)(int)++res1);
                    actualResult.setCharAt(2, (char)(int)++res2);
                }

                // ... what if there is no synchronization
                // Thread.sleep(0);
                // // Thread.sleep((int)((Math.random() * (max - min)) + min));
                // var res1 = Integer.valueOf(actualResult.charAt(0));
                // var res2 = Integer.valueOf(actualResult.charAt(2));
                // actualResult.setCharAt(0, (char)(int)++res1);
                // actualResult.setCharAt(2, (char)(int)++res2);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}