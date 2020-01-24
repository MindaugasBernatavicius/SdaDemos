package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

public class ExercisesWithConcurrency {
    public static void main(String[] args) throws InterruptedException {
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