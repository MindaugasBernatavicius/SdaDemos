package cf.mindaugas.sdademos._02_javaadvanced._16_lambdas;

public class _01_SimplifyingThreadingWLambdas {
    public static void main(String[] args) {
        // ... the old way
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from "
                        + Thread.currentThread().getName());
            }
        });
        t0.start();

        // Lambda expressions also simplify instantiation of runnable types
        Thread t1 = new Thread(() -> System.out.println("Hello from "
                + Thread.currentThread().getName()));
        t1.start();

        int[] array = {1, 5, 2};
        // ... reaching the array variable from outer scope
        Thread t2 = new Thread(() -> {
            int max = 0;
            for (int number : array) {
                if (max < number) max = number;
            }
            System.out.println("Max is: " + max);
        });
        t2.start();
    }
}
