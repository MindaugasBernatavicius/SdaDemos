package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class _10_Atomics {
    public static void main(String[] args) {
        BenchSynced bench = new BenchSynced(3);
        SeatTaker seatTaker1 = new SeatTaker(bench);
        SeatTaker seatTaker2 = new SeatTaker(bench);
        SeatTaker seatTaker3 = new SeatTaker(bench);
        SeatTaker seatTaker4 = new SeatTaker(bench);
        seatTaker1.start();
        seatTaker2.start();
        seatTaker3.start();
        seatTaker4.start();
    }
}

class SeatTaker extends Thread {
    private BenchSynced bench;
    public SeatTaker(BenchSynced bench) {
        this.bench = bench;
    }
    @Override public void run() {
        bench.takeASeat();
    }
}

class BenchSynced {
    private final AtomicInteger availableSeats = new AtomicInteger();
    public BenchSynced(int availableSeats) {
        this.availableSeats.set(availableSeats);
    }
    public void takeASeat() {
        // System.out.println("Before: " + availableSeats.get());
        // availableSeats.updateAndGet(value -> value > 0 ? --value : value);

        // updateAndGet() should not have side effects, but we can try :)
        availableSeats.updateAndGet(value -> {
            if (value > 0) {
                System.out.println("Taking seat!");
                return --value;
            } else {
                System.out.println("None left!");
                return value;
            }
        });

        // The function is reaplid, so 'taking a seat' appears many times.
        // ... however the value is always as expected,
        System.out.println("After: " + availableSeats.get());
    }
}