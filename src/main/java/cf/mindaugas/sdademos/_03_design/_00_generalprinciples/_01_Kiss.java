package cf.mindaugas.sdademos._03_design._00_generalprinciples;

import java.nio.file.FileSystemAlreadyExistsException;

public class _01_Kiss {

    public static void main(String[] args) {
        // _01_Kiss k = new _01_Kiss();
    }

    public String getWeekDayComplex(int day) {
        if ((day < 1) || (day > 7))
            throw new IllegalStateException("day must be in range 1 to 7");
        String[] days = {
                "Monday", // 0
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday" // 6
        };
        return days[day - 1]; // 7
    }

    // ... how can we write it simpler?


    public String getWeekDaySimple(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new IllegalStateException("day must be in range 1 to 7");
        }
    }
}
