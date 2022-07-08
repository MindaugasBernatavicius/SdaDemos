package cf.mindaugas.sdademos._02_javaadvanced._24_parallelStreams;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Warmup(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark) // state is linked to param annotation
public class _01_BenchingWithProbablePrime {

    // @Param({"10", "100"})
    @Param({"100"}) private int N;

    // @Param({"64", "128"})
    @Param({"64"}) private int BIT_LENGTH;

    BigInteger probablePrime() {
        return BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
    }

    @Benchmark
    public List<BigInteger> sum_of_N_Primes() {
        List<BigInteger> pps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
            pps.add(pp);
        }
        return pps;
    }

    @Benchmark
    public List<BigInteger> sum_of_N_Primes_no_resize() {
        List<BigInteger> pps = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
            pps.add(pp);
        }
        return pps;
    }

    @Benchmark
    public List<BigInteger> generate_N_primes () {
        return IntStream.range(0, N)
                .mapToObj(i -> probablePrime())
                .collect(toList());
    }

    @Benchmark
    public List<BigInteger> generate_N_primes_parallel() {
        return IntStream.range(0, N)
                .parallel()
                .mapToObj(i -> probablePrime())
                .collect(toList());
    }

    @Benchmark
    public List<BigInteger> generate_N_primes_parallel_unordered() {
        return IntStream.range(0, N)
                .unordered()
                .parallel()
                .mapToObj(i -> probablePrime())
                .collect(toList());
    }

    @Benchmark
    public List<BigInteger> generate_N_primes_parallel_limit() {
        return Stream.generate(() -> probablePrime())
                .parallel()
                .limit(N)
                .collect(toList());
    }

    @Benchmark
    public List<BigInteger> generate_N_primes_limit() {
        return Stream.generate(() -> probablePrime())
                .limit(N)
                .collect(toList());
    }

    public static void main(String[] args) throws RunnerException {
        // We can test the following:
        // .. iterative generation vs stream generation vs parallel stream generation
        // .. generating 10 primes is slower than generating 100 by ~10x
        // .. simple parallel generation can be faster by 6x on my machine (can you guess why that is)?

        Options opt = new OptionsBuilder()
                // .include(_01_BenchingWithProbablePrime.class.getName())
                // .include(_01_BenchingWithProbablePrime.class.getName() + ".sum_of_N_Primes")
                // .include(_01_BenchingWithProbablePrime.class.getName() + ".sum_of_N_Primes_no_resize")
                .include(_01_BenchingWithProbablePrime.class.getName() + ".generate_N_primes()")
                .include(_01_BenchingWithProbablePrime.class.getName() + ".generate_N_primes_parallel()")
                .build(); // Builder

        new Runner(opt).run();
    }
}
