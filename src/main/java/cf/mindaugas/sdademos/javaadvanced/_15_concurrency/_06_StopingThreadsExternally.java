package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

public class _06_StopingThreadsExternally {
    public static void main(String[] args) throws InterruptedException {
        Thread stopWatchThread = new Thread(new StopWatchToInterrupt());
        stopWatchThread.start();
        System.out.println("Going to interupt the thread");
        Thread.sleep(100);
        stopWatchThread.interrupt();
        stopWatchThread.join();
    }
}

class StopWatchToInterrupt implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Stop watch: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // In Java, one thread cannot stop the other thread.
                // A thread can only request the other thread to stop.
                // The request is made in the form of an interruption,
                // but we as developers decide how the thread will handle
                // interception request. In this case we can just break
                // in order to honor the intercept ... we could ignore it,
                // if there was some critical things that we needed to finish
                break;
            }
        }
    }
}
