package cf.mindaugas.sdademos._02_javaadvanced._24_parallelStreams;

import java.util.stream.IntStream;

public class _00_SimpleParallelStream {
    public static void main(String[] args) {
        System.out.println("Normal...");
        IntStream range = IntStream.rangeClosed(1, 10);
        range.forEach(System.out::println);

        System.out.println("Parallel...");
        IntStream range2 = IntStream.rangeClosed(1, 10);
        range2.parallel().forEach(System.out::println);
    }
}
