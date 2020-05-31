package cf.mindaugas.sdademos._01_codingfundamentals.v2_exercises._01_basics;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basics {

    /**
     * 0. Use a single System.out.print method to print the same statement in separate lines:
     * Hello world.
     * Hello world.
     */
    public static void printHelloWorld(){
        String lines[];

        // 0. Using escape sequence \n
        // System.out.print("Hello world!\nHello world!\n");
        // System.out.println("Hello world!\nHello world!");

        // 1.
        // for (int i = 0; i <= 1; i++){
        //     System.out.print("Hello world!\n");
        // }

        // i++ in more depth
        // int i = 1;
        // i++; // unary post-increment operator
        // i = i + 1;
        // i += 1;
        // System.out.println(i);

        // let's compare unary pre-increment and unary post-increment operator
        // int j = 1;
        // System.out.println(j);
        // // System.out.println(++j); // unary pre-increment
        // // System.out.println(j++); // unary post-increment

        // 2. while
        // int i = 0;
        // while (i < 2){
        //     System.out.println("Hello World!");
        //     i++;
        // }

        // 3 - do while
        int i = 0;
        do  {
            System.out.println("4 Hello world");
            i++;
        } while ( i > 1 );

        // 4
        i = 0;
        while ( i <= 1) {
            System.out.println("5 Hello world");
            i++;
        }

        // 5
        lines = new String[2];
        lines[0] = "Hello world";
        lines[1] = lines[0];

        for ( i = 0; i <= 1; i++ ) {
            if ( i == 1 ) {
                System.out.println(lines[i] + "\n");
            } else
                System.out.println(lines[i]);
        }
    }

    /**
     * 1. Enter any value with several digits after the decimal point
     * 2. and assign it to variable of type double.
     * 3. Display the given value rounded to two decimal places.
     */
    public static void roundDouble(){
        // 1.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite skaičių formatu: X.XXXX");

        // 2.
        double userInput = scanner.nextDouble();

        // 3.
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedUserInput = df.format(userInput);

        System.out.println(formattedUserInput);

        // ... trumpiau, jei nereikia objekto daugiau niekur panaudoti
        // System.out.println((new DecimalFormat("#.##").format(userInput)));

        // ATTENTION: if you have problems it might be due to LOCALE settings
        // Try to change the formatting string to #,## and then try
        // ... more info: https://stackoverflow.com/questions/36418901/change-decimalformat-locale
    }

    /**
     * 2. Display any three strings of characters on one line
     * so that they are aligned to the right edge of the 15-character blocks.
     * How to align strings to the left edge?
     */
    public static void allignTextToRight(){
        String[] stringArr = {"AAA", "BBBBB", "C"};

        System.out.print("|");
        for (int i = 0; i < stringArr.length; i++){
            // System.out.printf("-------|%15s|-------\n", stringArr[i]);
            System.out.printf("%15s|", stringArr[i]);
        }
    }

    /**
     * 3. Exercise to get better at printf formatting
     * Print a table | Name | Surname | Salary |
     * Each column has to be 20 characters wide.
     * Use the data provided
     */
    public static void printTable(){
        String[] data = {
                "Mindaugas", "Bernatavičius", "100",
                "Ramūnas", "Karbauskis", "99"};

        String marker = "\n-----------------------------------------------------------------";

        // Task - write this while header construction in one line
        System.out.println(marker);
        System.out.print("|");
        System.out.printf("%20s|", "Vardas");
        System.out.printf("%20s|", "Pavardė");
        System.out.printf("%20s|", "Atlyginimas");
        System.out.println(marker);

        // your logic
        for (int i = 0; i < data.length; i = i + 3){
            // ... simpler solution
            // System.out.print("|");
            // System.out.printf("|%20s|", data[i]);
            // System.out.printf("%20s|", data[i+1]);
            // System.out.printf("%20s|", data[i+2]);
            // System.out.println();

            // ... all in one line
            System.out.printf("|%20s|%20s|%20s|\n", data[i], data[i+1], data[i+2]);
        }
    }

    /**
     * Implement a function that will accept a parameter
     * in the form %-15s as a format specifier and another parameter
     * a variable to print.
     *
     * In the format specifier %-15s we say that:
     * - % will denote the start of formatting string
     * - then the minus sign (-) will specify the alignment (right/left)
     * - s/d - will specify the data type. Need to support string and int printing
     */

    /**
     * Simpler version
     */
    public static void myPrintf(String formatSpecifier, String varToPrint){
        Pattern pattern = Pattern.compile("%\\d+[sd]");
        Matcher m = pattern.matcher(formatSpecifier);
        System.out.println(m.matches());
        if(!m.matches()){
            System.out.println("Error in pattern!");
        }

        // Lets get the size of the block
        int blockSize = Integer.parseInt(
                m.group().substring(1, m.group().length() - 1));

        for(int i = 0; i < blockSize - varToPrint.length(); i++){
            System.out.print(" ");
        }
        System.out.println(varToPrint);
    }

    private static void myPrintFormatter(String format, String varToPrint) {
        Pattern p = Pattern.compile("%\\d+[ds]");
        Matcher m = p.matcher(format);
        if (!m.find())
            System.out.println("Error parsing");
        int spaceCount = Integer.parseInt(m.group().substring(1, m.group().length() - 1));

        String beforeFormatSpecifier = format.substring(0, format.indexOf(m.group()));
        char[] padding = new char[spaceCount];
        String afterFormatSpecifier = format.substring(format.indexOf(m.group()) + m.group().length());

        System.out.println(beforeFormatSpecifier + new String(padding) + varToPrint + afterFormatSpecifier);
    }

    // HOMEWORK:
    // 0. Extend this exercise to support %-15d, %15d and validate some user input
    // 1. Implement myPrintFormatter(String format, int varToPrint){}

    /**
     * 3. Enter two values of type int. Display their division casted to the double type
     * and rounded to the third decimal point.
     */

    /**
     * Sum two integer variables initialized with maximal values for that type (correctly).
     */
    public static void intMaxAddition(){
        // int first = Integer.MAX_VALUE;
        // int second = Integer.MAX_VALUE;
        // long result = (long)first + second;
        // System.out.println("" + first + " + " + second + " = " + result);

        // How about if we had two Long.MAX_VALUE varibles?
        BigInteger firstLong = new BigInteger("" + Long.MAX_VALUE);
        BigInteger secondLong = new BigInteger("" + Long.MAX_VALUE);
        BigInteger result = firstLong.add(secondLong);
        System.out.println("" + firstLong + " + " + secondLong + " = " + result);
    }

    /**
     * 5. Create three variables, one for each type: float, byte and char.
     * Enter values corresponding to those types using Scanner. What values are you able to enter for each type?
     */


    public static void main(String[] args) {
        // printHelloWorld();
        // roundNumbers();
        allignTextToRight();
    }
}
