package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

public class _00_TheardSleepMethod {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Main thread starts");
        Thread.sleep(2000); // ms
        System.out.println("Main thread is still running");
        Thread.sleep(2000); // ms
        System.out.println("Main thread ends");
    }
}
