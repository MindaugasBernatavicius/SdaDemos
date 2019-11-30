package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

public class _00_TheardSleepMethod {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Main thread starts");
        Thread.sleep(5000);
        System.out.println("Main thread is still running");
        Thread.sleep(5000);
        System.out.println("Main thread ends");
    }
}
