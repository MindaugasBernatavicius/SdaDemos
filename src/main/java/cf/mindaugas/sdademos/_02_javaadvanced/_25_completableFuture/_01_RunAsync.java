package cf.mindaugas.sdademos._02_javaadvanced._25_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_RunAsync {

    public static void running() throws InterruptedException {
        // .. this creates a daemon thread that does not prevent the JVM from exiting
        // .. this proves that the function call does not block
        CompletableFuture.runAsync(() -> System.out.println("Running async!"));

        System.out.println("Main thread");
        // .. so if there is no waiting, we will not see anything being printed.
        Thread.sleep(25);
    }

    public static void runningWithThreadName() throws InterruptedException {
        // ... this proves that CompletableFuture runs in the same FK Thread Pool as parallel streams
        System.out.println("Main thread " + Thread.currentThread().getName());
        CompletableFuture.runAsync(() -> System.out.println("Running async in the thread 1 " +  Thread.currentThread().getName()));
        CompletableFuture.runAsync(() -> System.out.println("Running async in the thread 2 " +  Thread.currentThread().getName()));
        CompletableFuture.runAsync(() -> System.out.println("Running async in the thread 3 " +  Thread.currentThread().getName()));
        Thread.sleep(100);
    }

    public static void runningInTheExecutorPool(){
        // ... in order not to compete with parallel streams for the same threads
        // ... we can use custom Deadpool for this specfic task
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(
                () -> System.out.println("Running async in the thread "
                        + Thread.currentThread().getName()),
                singleThreadExecutor);
        singleThreadExecutor.shutdown();
    }

    public static void runningInTheForkJoinPool() throws InterruptedException {
        Runnable task = () -> System.out.println("Running async in the thread " + Thread.currentThread().getName());
        CompletableFuture.runAsync(task);
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        // running();
        // runningWithThreadName();
        // runningInTheExecutorPool();
        // runningInTheForkJoinPool();
    }
}
