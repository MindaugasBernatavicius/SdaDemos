package cf.mindaugas.sdademos._00_javafundamentals.datetime.newjavatime;

import java.time.LocalDate;
import java.time.Period;

public class TimePeriod {
    public static void main(String[] args) {

        // The java.time.Period class models a quantity or amount of time in terms of years, months and days.

        LocalDate initialDate = LocalDate.parse("2007-05-10");
        System.out.println(">>>" + initialDate);

        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println(">>>" + finalDate);

        int diff = Period
                .between(finalDate, initialDate)
                .getDays();

        // diff = (int)ChronoUnit.DAYS.between(finalDate , initialDate);
        System.out.println(diff);
    }
}
