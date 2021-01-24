package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class _08_CallableReturningResultsAndExceptions {
    static String[] inputFiles = {
            "data/input/0.txt",
            "data/input/0.txt",
            "data/input/0.txt",
            "data/input/1.txt",
            // "data/input/2.txt",
            // "data/input/3.txt",
            // "data/input/4.txt",
            // "data/input/5.txt",
            // "data/input/6.txt",
            // "data/input/7.txt",
            // "data/input/8.txt",
            // "data/input/9.txt",
            // "data/input/10.txt",
            // "data/input/11.txt" // non existent file to trigger exception in the callable
    };

    public static void main(String[] args) throws InterruptedException {
        // // Result with regular threads
        // Thread[] threads = new Thread[inputFiles.length];
        // AdderReturn[] runnables = new AdderReturn[inputFiles.length];
        //
        // for (int i = 0; i < inputFiles.length; i++) {
        //     runnables[i] = new AdderReturn(inputFiles[i]);
        //     threads[i] = new Thread(runnables[i]);
        //     threads[i].start();
        // }
        //
        // int total = 0;
        // for (int i = 0; i < threads.length; i++){
        //     threads[i].join();
        //     total += runnables[i].getOutval();
        //     // System.out.println(runnables[i].getOutval());
        // }
        // System.out.println(total);

        // // Exception with regular threads
        // Thread[] threads = new Thread[inputFiles.length];
        // AdderException[] runnables = new AdderException[inputFiles.length];
        //
        // for (int i = 0; i < inputFiles.length; i++) {
        //     runnables[i] = new AdderException();
        //     threads[i] = new Thread(runnables[i]);
        //     threads[i].start();
        // }
        //
        // for (int i = 0; i < threads.length; i++) {
        //     threads[i].join();
        //     System.out.println(runnables[i].getException());
        // }

        // With Callable
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        // ExecutorService executor = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
        System.out.println(executor.prestartAllCoreThreads());

        List<Future<Integer>> futures = new ArrayList<>();
        for (String inputFile : inputFiles) {
            futures.add(executor.submit(new AdderCallable(inputFile)));
        }

        for (Future future : futures) {
            try {
                // future.get() returns 2 or raises an exception if the thread dies
                System.out.println(future.get()); // blocking
            } catch (ExecutionException e) {
                // e.printStackTrace();
                // to get the original exception
                System.err.println(e.getCause());
            }
        }

        executor.shutdown();
    }
}


class AdderReturn implements Runnable {
    private final String inFile;
    private int outval;

    public AdderReturn(String inFile) {
        this.inFile = inFile;
    }

    public double getOutval() {
        return this.outval;
    }

    @Override
    public void run() {
        try {
            performAddition();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void performAddition() throws IOException {
        double total = 0.0;
        String line = null;

        File fileIn = new File(inFile);
        if (!fileIn.isFile() && !fileIn.createNewFile()) {
            throw new IOException("Error reading file: " + fileIn.getAbsolutePath());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
            while ((line = br.readLine()) != null)
                this.outval += Double.parseDouble(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AdderException implements Runnable {
    private Exception exception;

    public Exception getException() {
        return exception;
    }

    @Override
    public void run() {
        try {
            performAddition();
        } catch (Exception e) {
            this.exception = e;
            // e.printStackTrace();
        }
    }

    public void performAddition() throws Exception {
        throw new Exception("Ha Ha!");
    }
}

class AdderCallable implements Callable<Integer> {
    private final String inFile;
    public AdderCallable(String inFile) {
        this.inFile = inFile;
    }

    @Override
    public Integer call() throws IOException {
        int total = 0;
        String line;

        File fileIn = new File(inFile);
        if (!fileIn.isFile()) {
            throw new IOException("Error reading file: " + fileIn.getAbsolutePath());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
            while ((line = br.readLine()) != null)
                total += Double.parseDouble(line);
        }

        return total;
    }
}