package cf.mindaugas.sdademos._00_javafundamentals.datetime.newjavatime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeLocalDate {

    public static void main(String[] args) {

        // The java.time.LocalDate class represents a date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03.
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);


        // LocalDate.of(2017, 12, 31);
        System.out.println(LocalDate.of(2017, 12, 31));

        // LocalDate.parse("2017-12-31");
        // LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(LocalDate.now().plusDays(1));

        LocalDate previousMonthSameDay = LocalDate.now()
                .minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);
        // DayOfWeek sunday = LocalDate.parse("2017-12-31")
        //         .getDayOfWeek();
        // boolean leapYear = LocalDate.now().isLeapYear();
        // boolean isAfter = LocalDate.parse("2016-06-12")
        //         .isAfter(LocalDate.parse("2014-06-21"));
    }
}
