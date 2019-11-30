package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

public class _01_ExtendingTheThreadClass {

    public static void main(String[] args) throws InterruptedException{
        //
        StopWatchThread stopWatchThread = new StopWatchThread();
        stopWatchThread.start();
        System.out.println("Main thread starts");
        Thread.sleep(5000);
        System.out.println("Main thread is still running");
        Thread.sleep(5000);
        System.out.println("Main thread ends");

        //
//        StopWatchThreadWPrefix stopWatchThread1 = new StopWatchThreadWPrefix("SW1");
//        StopWatchThreadWPrefix stopWatchThread2 = new StopWatchThreadWPrefix("SW2");
//        stopWatchThread1.start();
//        stopWatchThread2.start();
//        System.out.println("Main thread starts");
//        Thread.sleep(5000);
//        System.out.println("Main thread is still running");
//        Thread.sleep(5000);
//        System.out.println("Main thread ends");
    }

}

class StopWatchThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Stop watch: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StopWatchThreadWPrefix extends Thread {
    private String prefix;
    StopWatchThreadWPrefix(String prefix) {
        this.prefix = prefix;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(prefix + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}