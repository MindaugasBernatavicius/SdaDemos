package cf.mindaugas.sdademos._02_javaadvanced._05_enums;

public class PlanetsExercise {
    public static void main(String[] args) {
        for (Planets planet : Planets.values())
            System.out.println(planet);
    }
}

enum Planets {
    Mercury(4879.4),
    Venus(12104),
    Earth(12742),
    Mars(6779),
    Jupiter(139820),
    Saturn(116460),
    Uranus(50724),
    Neptune(49244),
    Pluto(2376.6);

    double diameter;

    Planets(double diameter) {
        this.diameter = diameter;
    }

    enum Sizes {
        Huge(100000),
        Large(10000),
        Normal(5000),
        Small(0);

        int size;

        Sizes(int size) {
            this.size = size;
        }
    }

    // Exercise :: create Create distanceFromEarth() method.

    @Override
    public String toString() {
        if (this.diameter < Sizes.Normal.size)
            return Sizes.Small + " " + this.name();
        else if (diameter < Sizes.Large.size)
            return Sizes.Normal + " " + this.name();
        else if (diameter < Sizes.Huge.size)
            return Sizes.Large + " " + this.name();
        else
            return Sizes.Huge + " " + this.name();
    }
}

// Example with the distances from earth, not diameters
enum Planets2 {
    Mercury("Small", 57.9),
    Venus("Medium", 108.2),
    Earth("Medium", 149.6),
    Mars("Small", 227.9),
    Jupiter("Huge", 778.3),
    Saturn("Huge", 1427.0),
    Uranus("Huge", 2871.0),
    Neptune("Huge", 4497.1);

    private String size;
    private double distInMillionsKm;

    Planets2(String size, double distInMillionsKm) {
        this.size = size;
        this.distInMillionsKm = distInMillionsKm;
    }

    public double distanceToEarth() {
        return this.distInMillionsKm;
    }

    @Override
    public String toString() {
        return this.size + " : " + this.name() + " : " + this.distanceToEarth();
    }
}
