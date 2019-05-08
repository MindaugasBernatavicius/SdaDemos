package cf.mindaugas.sdademos.javafundamentals.datetime.legacy;

import java.text.DateFormat;
import java.util.Date;

public class TextDateFormat {
    public static void main(String[] args) {

        Date currentDate = new Date();
        System.out.println("Current Date: " + currentDate);

        // 1)	final String format(Date date)	converts given Date object into string.
        String dateToStr = DateFormat.getInstance().format(currentDate);
        System.out.println("Date Format using getInstance(): " + dateToStr);

        // 2)	Date parse(String source)throws ParseException	converts string into Date object.
        // 3)	static final DateFormat getTimeInstance()	returns time formatter with default formatting style for the default locale.
        dateToStr = DateFormat.getTimeInstance().format(currentDate);
        System.out.println("Date Format using getTimeInstance(): "+ dateToStr);

        // 4)	static final DateFormat getTimeInstance(int style)	returns time formatter with the given formatting style for the default locale.
        dateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
        System.out.println("Date Format using getTimeInstance(DateFormat.SHORT): "+ dateToStr);

        // 5)	static final DateFormat getTimeInstance(int style, Locale locale)	returns time formatter with the given formatting style for the given locale.
        // 6)	static final DateFormat getDateInstance()	returns date formatter with default formatting style for the default locale.
        // 7)	static final DateFormat getDateInstance(int style)	returns date formatter with the given formatting style for the default locale.
        // 8)	static final DateFormat getDateInstance(int style, Locale locale)	returns date formatter with the given formatting style for the given locale.
        // 9)	static final DateFormat getDateTimeInstance()	returns date/time formatter with default formatting style for the default locale.
        // 10)	static final DateFormat getDateTimeInstance(int dateStyle,int timeStyle)	returns date/time formatter with the given date formatting style and time formatting style for the default locale.
        // 11)	static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale)	returns date/time formatter with the given date formatting style and time formatting style for the given locale.
        // 12)	static final DateFormat getInstance()	returns date/time formatter with short formatting style for date and time.
        // 13)	static Locale[] getAvailableLocales()	returns an array of available locales.
        // System.out.println(DateFormat.getAvailableLocales());

        // 14)	Calendar getCalendar()	returns an instance of Calendar for this DateFormat instance.
        // 15)	NumberFormat getNumberFormat()	returns an instance of NumberFormat for this DateFormat instance.
        // 16)	TimeZone getTimeZone()	returns an instance of TimeZone for this DateFormat instance.

    }
}