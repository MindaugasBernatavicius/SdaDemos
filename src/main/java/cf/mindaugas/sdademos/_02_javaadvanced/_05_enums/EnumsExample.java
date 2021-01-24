package cf.mindaugas.sdademos._02_javaadvanced._05_enums;

public class EnumsExample {
    public static void main(String[] args) {

        // 1. Initialization
        LengthUnit unit = LengthUnit.METER;
        System.out.println(LengthUnit.METER); // prints "METER"

        // 2. Usage with switch
        // switch statement
        switch (unit) {
            case FOOT:
                System.out.println("Foot unit is selected");
                break;
            case METER:
                System.out.println("Meter unit is selected");
                break;
            case INCH:
                System.out.println("Inch unit is selected");
                break;
            case CENTIMETER:
                System.out.println("Centimeter unit is selected");
                break;
        }

        // Why use enums at all
        // - autocomplete
        // - compile time safety (with string you can make mistake in a switch statement)
        String s = "ABC";
        switch (s) {
            case "FOOT":
            case "METE":
        }

        // 3.
        System.out.println(LengthUnit.METER.convertToMeters());

        // 4.
        for (LengthUnit lengthUnit : LengthUnit.values()) {
            System.out.println(lengthUnit);
        }

        System.out.println(LengthUnit.values());
    }
}

// enum LengthUnit {
//     METER,
//     CENTIMETER,
//     FOOT,
//     INCH
// }

enum LengthUnit {
    METER(1, "Meter unit"),
    CENTIMETER(0.01, "Centimeter unit"),
    FOOT(0.3, "Foot unit"),
    INCH(0.025, "Inch unit");

    double valueComparedToMeter;
    String prettyName;

    LengthUnit(double value, String prettyName) {
        this.valueComparedToMeter = value;
        this.prettyName = prettyName;
    }

    // Constructor overloading is possible
    LengthUnit(String prettyName) {
        this.prettyName = prettyName;
    }

    // returns value - length in meters
    double convertToMeters() {
        return valueComparedToMeter;
    }

    @Override
    public String toString() {
        return prettyName;
    }
}

