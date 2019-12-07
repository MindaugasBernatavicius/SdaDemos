package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

public class _04_Synchronization {
    public static void main(String[] args) {
//        Bench bench = new Bench(1); // creating bench with one free seat
//        SeatTakerThread seatTaker1 = new SeatTakerThread(bench);
//        SeatTakerThread seatTaker2 = new SeatTakerThread(bench);
//        seatTaker1.start();
//        seatTaker2.start();

        // ... in this case result are unpredictable. We need synchronization
        Bench bench = new Bench(1); // creating bench with one free seat
        SeatTakerThread seatTaker1 = new SeatTakerThread(bench);
        SeatTakerThread seatTaker2 = new SeatTakerThread(bench);
        seatTaker1.start();
        seatTaker2.start();
    }
}

class SeatTakerThread extends Thread {
    private Bench bench;
    public SeatTakerThread(Bench bench) {
        this.bench = bench;
    }
    @Override
    public void run() {
        bench.takeASeat();
    }
}

//class Bench {
//    private int availableSeats;
//    public Bench(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//    public void takeASeat() {
//        if (availableSeats > 0) {
//            System.out.println("Taking a seat.");
//            availableSeats--;
//            System.out.println("Free seats left " + availableSeats);
//        } else {
//            System.out.println("There are no available seats. :^(");
//        }
//    }
//}

class Bench {
    private int availableSeats;
    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public synchronized void takeASeat() {
        if (availableSeats > 0) {
            System.out.println("Taking a seat.");
            availableSeats--;
            System.out.println("Free seats left " + availableSeats);
        } else {
            System.out.println("There are no available seats. :^(");
        }
    }
}