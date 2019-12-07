package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.util.Arrays;
import java.util.List;

public class _03_Reduction {
    public static void main(String[] args) {

        int myArray[] = { 1, 5, 8 };
        int sum1 = Arrays.stream(myArray).sum();
        System.out.println("The sum of all elements is " + sum1);


        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array.stream().reduce(0,
                (partialResult, currentElement) -> partialResult + currentElement);

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);
    }
}
