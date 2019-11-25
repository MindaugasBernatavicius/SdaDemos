package cf.mindaugas.sdademos.javaadvanced._05_enums;

public class EnumsExample {
    public static void main(String[] args) {
        LengthUnit meterUnit = LengthUnit.METER;
        System.out.println(LengthUnit.METER); // prints "METER"

        // switch statement
        switch(meterUnit) {
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

        //
        System.out.println(LengthUnit.FOOT.convertToMeters());

        //
        for (LengthUnit lengthUnit : LengthUnit.values()) {
            System.out.println(lengthUnit);
        }

        //
        System.out.println(LengthUnit.CENTIMETER);
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

    double value;
    String prettyName;

    LengthUnit(double value, String prettyName) {
        this.value = value;
        this.prettyName = prettyName;
    }

    // returns value - length in meters
    double convertToMeters() {
        return value;
    }

    @Override
    public String toString() {
        return prettyName;
    }
}

