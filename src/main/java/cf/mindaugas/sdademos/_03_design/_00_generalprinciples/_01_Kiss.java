package cf.mindaugas.sdademos._03_design._00_generalprinciples;

public class _01_Kiss {
    public static void main(String[] args) {
        // System.out.println(getWeekDayComplex(5));
        // System.out.println(getWeekDaySimple(5));
        System.out.println(getWeekDaySimpleSwExpr(5));
    }

    public static String getWeekDayComplex(int day) {
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

    public static String getWeekDaySimple(int day) {
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

    public static String getWeekDaySimpleSwExpr(int day) {
        return switch(day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalStateException(
                "day must be in range 1 to 7"
            );
        };
    }
}
