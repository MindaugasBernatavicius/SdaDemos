package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._06_Flyweight.nonsda;

public class _01_FlyweightUsage {

    public static void main(String[] args) throws Exception {

        Integer firstInt = Integer.valueOf(5);
        Integer secondInt = Integer.valueOf(5);
        Integer thirdInt = Integer.valueOf(10);

        System.out.println(System.identityHashCode(firstInt));
        System.out.println(System.identityHashCode(secondInt));
        System.out.println(System.identityHashCode(thirdInt));

    }
}
