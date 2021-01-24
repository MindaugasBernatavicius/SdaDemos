package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _07_ThreadPoolsExecutorService {
    static String[] inputFiles = {
            "data/input/1.txt",
            "data/input/2.txt",
            "data/input/3.txt",
            "data/input/4.txt",
            "data/input/5.txt",
            "data/input/6.txt",
            "data/input/7.txt",
            "data/input/8.txt",
            "data/input/9.txt",
            "data/input/10.txt"
    };
    static String[] outputFiles = {
            "data/output/1.txt",
            "data/output/2.txt",
            "data/output/3.txt",
            "data/output/4.txt",
            "data/output/5.txt",
            "data/output/6.txt",
            "data/output/7.txt",
            "data/output/8.txt",
            "data/output/9.txt",
            "data/output/10.txt"
    };

    public static void main(String[] args) throws IOException, InterruptedException {
        // Thread[] threads = new Thread[inputFiles.length];
        // long startTime = System.nanoTime();
        // for (int i = 0; i < inputFiles.length; i++) {
        //     AdderR adder = new AdderR(inputFiles[i], outputFiles[i]);
        //     threads[i] = new Thread(adder);
        //     threads[i].start();
        // }
        // for (Thread t : threads)
        //     t.join();
        // long stopTime = System.nanoTime();
        // System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");

        //  never more than 3 at the same time
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.nanoTime();
        for (int i = 0; i < inputFiles.length; i++) {
            AdderR adder = new AdderR(inputFiles[i], outputFiles[i]);
            executorService.submit(adder);
        }
        // should handle Interuptable exceptions
        executorService.shutdown();

        // // executorService.awaitTermination(60, TimeUnit.MILLISECONDS);
        // if (!executorService.isTerminated()){
        //     executorService.awaitTermination(6000, TimeUnit.MILLISECONDS);
        //     long stopTime = System.nanoTime();
        //     System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");
        // } else {
        //     long stopTime = System.nanoTime();
        //     System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");
        // }

        long stopTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");
    }
}