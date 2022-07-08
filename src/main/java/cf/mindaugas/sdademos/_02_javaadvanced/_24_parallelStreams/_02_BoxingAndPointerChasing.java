package cf.mindaugas.sdademos._02_javaadvanced._24_parallelStreams;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Warmup(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class _02_BoxingAndPointerChasing {

    @Param({"100000"})
    private int N;

    private int[] arrayOfInts;
    private Integer[] arrayOfIntegers;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private LinkedList<Integer> suffledLinkedList = new LinkedList<>();
    private LinkedList<Integer> scatteredLinkedList = new LinkedList<>();

    @Setup
    public void createArrayList() {
        arrayList = IntStream.range(0, N)
                .map(i -> i*3)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Setup
    public void createLinkedList() {
        linkedList = IntStream.range(0, N)
                .map(i -> i*3)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Setup
    public void createShuffledLinkedList() {
        suffledLinkedList = new LinkedList<>();
        for (int i = 1 ; i < N + 1 ; i++) {
            suffledLinkedList.add(i*3);
        }
        Collections.shuffle(suffledLinkedList, new Random(314159L));
    }

    @Setup
    // adding zeros when generating numbers
    // .. and then removing them to increase cache misses
    public void createScatteredLinkedList() {
        scatteredLinkedList = new LinkedList<>();
        for (int i = 1 ; i < N + 1 ; i++) {
            scatteredLinkedList.add(i*3);
            for (int j = 0 ; j < 100 ; j++) {
                scatteredLinkedList.add(0);
            }
        }
        scatteredLinkedList.removeIf(i -> i == 0);
    }

    @Setup
    public void createArrayOfInts() {
        arrayOfInts = new int[N];
        for(int i = 0; i < N; i++) {
            arrayOfInts[i] = 3 * i;
        }
    }

    @Setup
    public void createArrayOfIntegers() {
        arrayOfIntegers = new Integer[N];
        for(int i = 0; i < N; i++) {
            arrayOfIntegers[i] = 3 * i;
        }
    }

    @Benchmark
    public int calculate_sum_of_ints() {
        int sum = 0;
        for (int i = 0; i < arrayOfInts.length ; i++) {
            sum += i*7;
        }
        return sum;
    }

    @Benchmark
    public int calculate_sum_of_integers() {
        Integer sum = 0;
        for (int i = 0; i < arrayOfIntegers.length ; i++) {
            sum += i*7;
        }
        return sum;
    }

    @Benchmark
    public int calculate_sum_of_range() {
        return IntStream.range(0, N)
                .map(i -> i*3)
                .map(i -> i*7)
                .sum();
    }

    @Benchmark
    public int calculate_sum_of_range_boxed() {
        return IntStream.range(0, N)
                .boxed()
                .map(i -> i*3)
                .map(i -> i*7)
                .reduce(0, Integer::sum);
    }

    @Benchmark
    public int calculate_sum_of_array_list() {
        return arrayList.stream()
                .mapToInt(i -> i)
                .map(i -> i*5)
                .sum();
    }

    @Benchmark
    public int calculate_sum_of_linked_list() {
        return linkedList.stream()
                .mapToInt(i -> i)
                .map(i -> i*5)
                .sum();
    }

    @Benchmark
    public int calculate_sum_of_linked_list_shuffled() {
        return suffledLinkedList.stream()
                .mapToInt(i -> i)
                .map(i -> i*5)
                .sum();
    }

    @Benchmark
    public int calculate_sum_of_linked_list_scattered() {
        return scatteredLinkedList.stream()
                .mapToInt(i -> i)
                .map(i -> i*5)
                .sum();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                // .include(_02_BoxingAndPointerChasing.class.getName())
                .include(_02_BoxingAndPointerChasing.class.getName() + ".calculate_sum_of_array_list()")
                .include(_02_BoxingAndPointerChasing.class.getName() + ".calculate_sum_of_linked_list()")
                .include(_02_BoxingAndPointerChasing.class.getName() + ".calculate_sum_of_linked_list_shuffled()")
                .include(_02_BoxingAndPointerChasing.class.getName() + ".calculate_sum_of_linked_list_scattered()")
                .build();
        new Runner(opt).run();
    }
}
