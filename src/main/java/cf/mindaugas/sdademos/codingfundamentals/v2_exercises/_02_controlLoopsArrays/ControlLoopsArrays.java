package cf.mindaugas.sdademos.codingfundamentals.v2_exercises._02_controlLoopsArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlLoopsArrays {

    /**
     * Write an application that will show if entered value is greater, equal or lower than 30.
     */

    /**
     * As above but compare two values at the same time. Verify if first value is greater than 30 and second value is greater than 30, and so on.
     */

    /**
     * As above but only one of the values has to be greater, equal or lower than 30.
     */

    /**
     * Write an application that for any entered number between 0 and 9 will provide it’s name. For example for “3” program should print “three”.
     */

    /**
     * Remembering arrays, 2D arrays and nested for loops
     */
    public static void printArray() {

        String[] myArr = {"Tomas", "Tadas", "Jonas"};

        // print every value inside an array
        // for (int i = 0 ; i < myArr.length; i++){
        //     System.out.println(myArr[i]);
        // }

        // print every second (2nd) value in the array
        for (int i = 0; i < myArr.length; i += 2) {
            System.out.println(myArr[i]);
        }
    }

    public static void print2DArray() {
        String[][] arr2d = {
                //   0          1          2
                {"Tomas", "Petraitis", "168"},    // 0
                {"Tadas", "Jonaitis", "179"},     // 1
                {"Mantas", "Kavarskas", "181"},   // 2
                {"Petras", "Petrarskas", "180"},  // 3
                {"Antanas", "Gražulis", "189"},   // 4
                {"Martynas", "Baisulis", "201"}   // 5
        };

        // System.out.println(arr2d[2][2]);

        int counter = 0;
        for (int i = 0; i < arr2d.length; i++) {
            // System.out.println(arr2d[i]); // prints just the hascode of each subarray
            // System.out.println(Arrays.toString(arr2d[i])); // printing the nested array
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print(arr2d[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
        // System.out.println(counter);
    }

    /**
     * Using nested for loops draw (parents loop iterator should be called “row”, child – “column”):
     * - square
     * - triangle,
     * - drawPyramid,
     * - rectangle with diagonals,
     * - christmas tree
     */
    public static void drawSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void drawTriangle(int height) {
        for (int row = 1; row < height + 1; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // TODO
    public static void drawTriangleReverse(int size) {
        for (int row = 0; row < size; row++) {
            for (int collumn = 0; collumn < size; collumn++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void drawPyramid(int height) {
        for (int row = 1; row < height + 1; row++) {
            for (int column = 1; column < height + 1; column++) {
                if (column + row == height + 1)
                    for (int i = 1; i < row + row; i++)
                        System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    /**
     * Draw a Christmas tree from a pyramid,
     *
     * @param size - size of the xmas tree
     * @param year - the size of trunk of the tree
     */
    private static void drawPyramidFromInternet(int size, int year) {
        for (int i = 1; i <= size; i++) {
            // loop to print the number of spaces before the star
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            // loop to print the number of stars in each row
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // for new line after printing each row
            System.out.println();
        }
        for (int k = 0; k <= size - year; k++) {
            System.out.print(" ");
        }
        for (int p = 0; p < year; p++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int z = 0; z <= size - year; z++) {
            System.out.print(" ");
        }
        for (int x = 0; x < year; x++) {
            System.out.print("* ");
        }
    }

    // TODO
    public static void drawRectangleWithDiagonals(int size) {

    }

    public static void drawChristmasTree(int height) {
        for (int row = 1; row < height + 1; row++) {
            for (int column = 0; column < height; column++) {
                if (column * 2 == height - row)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }


    /**
     * Write a simple application that will simulate shopping process. Use only if-else flow control. Consider following cases:
     * - If you would like to buy a bottle of milk – cashier will ask you for a specific amount of money.
     * You have to enter that value and verify if it is same as the cashier asked.
     * - If you would like to buy a bottle of wine – cashier will ask you if you are an adult and for positive answer ask for a specific amount of money.
     */
    public static void drinkShop() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ką norėtumėte nusipirkti (pienas / vynas)?");

        String whatToBuyAnswer = sc.nextLine();

        while (!whatToBuyAnswer.equalsIgnoreCase("pienas")
                && !whatToBuyAnswer.equalsIgnoreCase("vynas")) {
            System.out.println("Įveskite pienas arba vynas!");
            whatToBuyAnswer = sc.nextLine();
        }

        if (whatToBuyAnswer.equalsIgnoreCase("pienas")) {
            double milkPrice = 3.99;
            System.out.println("Pieno kaina: " + milkPrice + ", prašome sumokėti.");
            double customersPaidAmount = sc.nextDouble();
            if (milkPrice > customersPaidAmount) {
                System.out.println("Nepakako sumokėtų pinigų!");
            } else {
                if ((milkPrice < customersPaidAmount)) {
                    System.out.println("Graža: " + new DecimalFormat("#.###").format((customersPaidAmount - milkPrice)));
                }
                System.out.println("Skanaus pieno, geros dienos!");
            }
        } else {
            int ageOfLegalConsumption = 20;

            System.out.println("Koks jūsų amžius?");
            int customersAge = sc.nextInt();

            if (ageOfLegalConsumption > customersAge) {
                System.out.println("Jūs per jaunas, pirkti vyną. Siūlome pirkti pieną!");
            } else {
                double winePrice = 6.99;
                System.out.println("Vyno kaina: " + winePrice + ", prašome sumokėti.");
                double customersPaidAmount = sc.nextDouble();
                if (winePrice > customersPaidAmount) {
                    System.out.println("Nepakako sumokėtų pinigų!");
                } else {
                    if ((winePrice < customersPaidAmount)) {
                        System.out.println("Graža: " + new DecimalFormat("#.###").format((customersPaidAmount - winePrice)));
                    }
                    System.out.println("Skanaus vyno, geros dienos!");
                }
            }
        }
    }

    /**
     * Homework:
     * - Find all the places where we can ask the user to enter a value one more time, when he makes a mistake (while loop).
     * - Extract the logic responsible to checking the price against user's entered money value. It should be a separate method.
     */
    public static double handleCustomerPayment(Scanner sc){
        Matcher matcher;
        do {
            String customersPaidAmountStr = sc.nextLine();
            Pattern pattern = Pattern.compile("\\d{0,3}(\\.\\d{0,2})?");
            matcher = pattern.matcher(customersPaidAmountStr);
        } while(!matcher.matches());
        return Double.parseDouble(matcher.group());
    }

    public static void handleDrinkPrice(String drinkType, double price, Scanner sc) {
        System.out.println(drinkType.substring(0, 1).toUpperCase()
                + drinkType.substring(1) + " kaina: " + price + ", prašome sumokėti.");

        sc.nextLine();
        double customersPaidAmount = handleCustomerPayment(sc);

        while (price > customersPaidAmount) {
            System.out.println("Nepakako sumokėtų pinigų! Įdėkite trūkstamus.");
            customersPaidAmount = customersPaidAmount + handleCustomerPayment(sc);
        }

        if ((price < customersPaidAmount))
            System.out.println("Graža: " + new DecimalFormat("#.###").format((customersPaidAmount - price)));

        System.out.println("Skanaus " + drinkType + ", geros dienos!");
    }

    public static void drinkShopRefactored() {

        double milkPrice = 3.99;
        double winePrice = 6.99;
        int ageOfLegalConsumption = 20;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ką norėtumėte nusipirkti (pienas / vynas)?");
        String whatToBuyAnswer = sc.nextLine();

        while (!whatToBuyAnswer.equalsIgnoreCase("pienas")
                && !whatToBuyAnswer.equalsIgnoreCase("vynas")) {
            System.out.println("Įveskite pienas arba vynas!");
            whatToBuyAnswer = sc.nextLine();
        }

        if (whatToBuyAnswer.equalsIgnoreCase("pienas")) {
            handleDrinkPrice("pieno", milkPrice, sc);
        } else {
            System.out.println("Koks jūsų amžius?");
            int customersAge = sc.nextInt();
            if (ageOfLegalConsumption > customersAge) {
                System.out.println("Jūs per jaunas, pirkti vyną. Siūlome pirkti pieną!");
            } else {
                handleDrinkPrice("vyno", winePrice, sc);
            }
        }
    }

    /**
     * Write a simple “echo” application, that will:
     * print back entered string,
     * go to the beginning of a loop if user will enter “continue”,
     * break the loop with a “good bye!” message, if user will enter “quit”.
     */

    /**
     * Write an application that will find biggest value within array of int variables.
     * check your application using randomly generated array (use Random class),
     * check your application at least 5 times
     * (generate random array → print array to the console → find biggest value → print biggest value →  manually verify results).
     */

    /**
     * Write an application that will find the longest char sequence within an array of type String.
     * Test it in the same way as you have done in the previous exercise. How will you generate random char sequences?
     */
    private static char[] generateRepetitiveCharSequence(){
        // generate random number indicating how many sequences will current string have
        int sequenceLength = (int)(Math.random() * 10) + 1;
        char[] sequence = new char[sequenceLength];
        for (int j = 0; j < sequenceLength; ) {
            int repeatingLetterCount = (new Random()).nextInt(sequenceLength - j) + 1;
            char c = (char)((new Random()).nextInt(26) + 'a'); // choose random letter
            for (int k = 0; k < repeatingLetterCount; k++){ // repeat the random letter
                sequence[j] = c;
                j++;
            }
        }
        return sequence;
    }

    private static String[] generateRandomStringArr(int limitOnSequenceCount){
        // generate random number indicating how long the array of strings will be
        int totalStrings = (int)(Math.random() * limitOnSequenceCount) + 1;
        String[] stringArr = new String[totalStrings];
        for (int i = 0; i < totalStrings; i++)
            stringArr[i] = new String(generateRepetitiveCharSequence());
        return stringArr;
    }

    public static void findLongestRepeatingSequence(){
        // generate an array of sequences composed of repeating characters
        System.out.println(Arrays.toString(generateRandomStringArr(15)));
    }

    public static void main(String[] args) {
        // drawTriangle(10);
        // drawPyramid(10);
        // drawRectangleWithDiagonals(10);
        // drawChristmasTree(10); // a christmas tree can be just a bunch of pyramids on top of one another
        // drinkShop();
        // drinkShopRefactored();
        findLongestRepeatingSequence();
    }
}
