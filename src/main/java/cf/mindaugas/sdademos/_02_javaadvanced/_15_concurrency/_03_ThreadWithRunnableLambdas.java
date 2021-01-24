package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

public class _03_ThreadWithRunnableLambdas {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnableBlock0 = () -> {
            for (int i = 0; i < 100; i++)
                System.out.println(
                        "RB0: Im running in: " + Thread.currentThread().getName() +
                                "w/ priority: " + Thread.currentThread().getPriority());
        };

        Runnable runnableBlock1 = () -> {
            for (int i = 0; i < 100; i++)
                System.out.println("RB1:" + i);
        };

        Thread t0 = new Thread(runnableBlock0);
        t0.start();
        // t0.run();
        // does not create any new thread.
        // Instead it execute the run method in the current running thread synchronously.

        Thread t1 = new Thread(runnableBlock1);
        t1.start();

        for (int i = 0; i < 100; i++)
            System.out.println("main" + i);
        //... or we can use

        // ensure main thread is running untill all the other threads have not finished.
        t0.join();
        t1.join();
    }
}
