package cf.mindaugas.sdademos._02_javaadvanced._15_concurrency;

public class _04_Synchronization {
    public static void main(String[] args) {
        // ... in this case result are unpredictable. We need synchronization
        Bench bench = new Bench(2); // creating bench with one free seat
        SeatTakerThread seatTaker1 = new SeatTakerThread(bench);
        SeatTakerThread seatTaker2 = new SeatTakerThread(bench);
        SeatTakerThread seatTaker3 = new SeatTakerThread(bench);
        seatTaker1.start();
        seatTaker2.start();
        seatTaker3.start();
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

// ... no sync
// class Bench {
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
// }

// ... sync
class Bench {
    private int availableSeats;
    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    // // the entire method is locked
    // public synchronized void takeASeat() {
    //     if (availableSeats > 0) {
    //         System.out.println("Taking a seat.");
    //         availableSeats--;
    //         System.out.println("Free seats left " + availableSeats);
    //     } else {
    //         System.out.println("There are no available seats. :^(");
    //     }
    // }

    public void takeASeat() {
        // sync only the critical part / critical execution block
        // ... System.out.println("Unsynced part");
        synchronized (this){
            if (availableSeats > 0) {
                System.out.println("Taking a seat.");
                availableSeats--;
                System.out.println("Free seats left " + availableSeats);
            } else {
                System.out.println("There are no available seats. :^(");
            }
        }
    }
}
