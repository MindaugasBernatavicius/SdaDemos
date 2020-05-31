package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._04_iterator.nonsda;

import java.util.Iterator;

public class _02_CustomIterator {
    public static void main(String[] args) {
        BikeRepository repo = new BikeRepository();
        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");

        Iterator<String> bikeIterator = repo.iterator();

        // while(bikeIterator.hasNext()) {
        // 	System.out.println(bikeIterator.next());
        // }

        for (String bike : repo) {
        	System.out.println(bike);
        }

        // int i = 1;
        // while(bikeIterator.hasNext()) {
        //     System.out.println("|" + i + "|" + bikeIterator.next() + "|");
        //     i++;
        // }
    }
}

class BikeRepository implements Iterable<String> {
    private String[] bikes;
    private int index;

    public BikeRepository() {
        bikes = new String[10];
        index = 0;
    }

    public void addBike(String bike) {
        // resize operation
        if(index == bikes.length) {
            String[] largerBikes = new String[bikes.length + 5];
            System.arraycopy(bikes, 0, largerBikes, 0, bikes.length);
            bikes = largerBikes;
            largerBikes = null;
        }
        bikes[index] = bike;
        index++;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < bikes.length && bikes[currentIndex] != null;
            }
            @Override
            public String next() {
                // String bike = bikes[currentIndex];
                // currentIndex++;
                // return bike;
                // ... instead of this, we can do this:
                return bikes[currentIndex++]; // ++currentIndex
            }
            @Override
            public void remove() {
                // implement as a homework - resize the array, shrink it
                throw new UnsupportedOperationException();
            }

            // Homework suggestion: implement method go back / traverse backwards
        };
        return it;
    }
}
