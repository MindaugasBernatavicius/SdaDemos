package cf.mindaugas.sdademos._02_javaadvanced._25_completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class _03_Chaining {
    public static void runningWithListOf() throws InterruptedException {
        CompletableFuture<List<Integer>> res = CompletableFuture.supplyAsync(() -> List.of(1, 2, 3));
        Thread.sleep(100);
    }

    public static void runningWithThenApply() throws InterruptedException, ExecutionException {

        String name1 = "Jonas";
        String name2 = "Petras";

        CompletableFuture<Integer> res = CompletableFuture
                .supplyAsync(() -> List.of(new Person(name1), new Person(name2)))
                .thenApply(list -> list.size());

        System.out.println(res.get());
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // runningWithListOf();
        runningWithThenApply();
    }
}

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}