package cf.mindaugas.sdademos.javaadvanced._08_nestedclasses;

import java.util.Iterator;
import java.util.ListIterator;

public class IteratorExample {
    public static void main(String[] args) {
        // 0. Iterator as a separate class
        Flight f0 = new Flight(
                new CrewMember[]{ new CrewMember("Mindaugas", "Stiuard") },
                new Passenger[]{ new Passenger("Petras", 223)}
            );

         FlightIterator fi0 = new FlightIterator(f0.getCrew(), f0.getPassengers());
         while(fi0.hasNext())
             System.out.println(fi0.next());

        // 1. Iterator as an Inner Class
        Flight1 f1 = new Flight1(
                new CrewMember[]{ new CrewMember("Mindaugas", "Stiuard") },
                new Passenger[]{ new Passenger("Petras", 223)}
        );

         Iterator fi1 = f1.iterator();
         while(fi1.hasNext())
             System.out.println(fi1.next());

        // 2. Iterator as an Anonymous Inner Class
        Flight1 f2 = new Flight1(
                new CrewMember[]{ new CrewMember("Mindaugas", "Stiuard") },
                new Passenger[]{ new Passenger("Petras", 223)}
        );

        Iterator fi2 = f2.iterator();
        while(fi2.hasNext())
            System.out.println(fi2.next());
    }
}

// 0. Iterator as a separate class
class FlightIterator implements Iterator {
    private CrewMember[] crew;
    private Passenger[] passengers;
    private int idx = 0;

    public FlightIterator(CrewMember[] crew, Passenger[] passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    @Override
    public boolean hasNext() {
        return idx < (crew.length + passengers.length);
    }

    @Override
    public Object next() {
        Object o = (idx < crew.length)
                ? crew[idx]
                : passengers[idx - crew.length];
        idx++;
        return o;
    }
}


// ... just mention this
class FlightListIterator implements ListIterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Object previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Object o) {

    }

    @Override
    public void add(Object o) {

    }
}


// 1. Iterator as an Inner Class
class Flight1 {
    private CrewMember[] crew;
    private Passenger[] passengers;

    public Iterator iterator(){
        return new FlightIterator(this.crew, this.passengers);
    }

    private class FlightIterator implements Iterator {
        private CrewMember[] crew;
        private Passenger[] passengers;
        private int idx = 0;

        public FlightIterator(CrewMember[] crew, Passenger[] passengers) {
            this.crew = crew;
            this.passengers = passengers;
        }

        @Override
        public boolean hasNext() {
            return idx < (crew.length + passengers.length);
        }

        @Override
        public Object next() {
            Object o = (idx < crew.length)
                    ? crew[idx]
                    : passengers[idx - crew.length];
            idx++;
            return o;
        }
    }

    public Flight1(CrewMember[] crew, Passenger[] passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    public CrewMember[] getCrew() {
        return crew;
    }

    public void setCrew(CrewMember[] crew) {
        this.crew = crew;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}

// 2. Iterator as an Anonymous Inner Class
class Flight2 {
    private CrewMember[] crew;
    private Passenger[] passengers;

    public Iterator iterator() {
        return new Iterator() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < (crew.length + passengers.length);
            }

            @Override
            public Object next() {
                Object o = (idx < crew.length)
                        ? crew[idx]
                        : passengers[idx - crew.length];
                idx++;
                return o;
            }
        };
    }

    public Flight2(CrewMember[] crew, Passenger[] passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    public CrewMember[] getCrew() {
        return crew;
    }

    public void setCrew(CrewMember[] crew) {
        this.crew = crew;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}

// ... helper classes

class CrewMember {
    private String name;
    private String occupation;

    public CrewMember(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}

class Passenger {
    private String name;
    private int seatNumber;

    public Passenger(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}

class Flight {
    private CrewMember[] crew;
    private Passenger[] passengers;

    public Flight(CrewMember[] crew, Passenger[] passengers) {
        this.crew = crew;
        this.passengers = passengers;
    }

    public CrewMember[] getCrew() {
        return crew;
    }

    public void setCrew(CrewMember[] crew) {
        this.crew = crew;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}
