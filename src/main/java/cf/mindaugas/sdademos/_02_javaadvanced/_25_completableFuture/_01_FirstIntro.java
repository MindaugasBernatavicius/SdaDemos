package cf.mindaugas.sdademos._02_javaadvanced._25_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_FirstIntro {

    public static void running(){
        // .. this creates a demon thread that does not prevent the JVM from exiting
        CompletableFuture.runAsync(() -> System.out.println("Running async!"));
        // .. so if there is no waiting, we will not see anything being printed.
        // Thread.sleep(100);
    }

    public static void runningInTheExecutorPool(){
        ExecutorService es = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("Running async in the thread " + Thread.currentThread().getName());
        CompletableFuture.runAsync(task, es);
        es.shutdown();
    }

    public static void runningInTheForkJoinPool() throws InterruptedException {
        Runnable task = () -> System.out.println("Running async in the thread " + Thread.currentThread().getName());
        CompletableFuture.runAsync(task);
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        // running();
        runningInTheExecutorPool();
        runningInTheForkJoinPool();
    }
}
