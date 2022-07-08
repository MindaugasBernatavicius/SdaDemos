package cf.mindaugas.sdademos._02_javaadvanced._25_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _02_SupplyAsync {
    public static void runningSupplyAsync() throws InterruptedException, ExecutionException {
        // Takes a Supplier<T> functional interface
        CompletableFuture<Integer> res = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running async!");
            return 0;
        });
        System.out.println(res.get());
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        runningSupplyAsync();
    }
}
