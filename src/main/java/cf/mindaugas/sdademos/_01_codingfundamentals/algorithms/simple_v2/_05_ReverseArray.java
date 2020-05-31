package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.simple_v2;

import java.util.Arrays;

public class _05_ReverseArray {

    // naive / simple way
    private static int[] reverseBruteForce(int[] originalArr){
        int[] reversedArr = new int[originalArr.length];
        for(int i = 0; i < originalArr.length; i++)
            reversedArr[i] = originalArr[originalArr.length - 1 - i];
        return reversedArr;
    }

    // faster and requires less memory, but harder to read
    private static int[] reverseMoreEfficient(int[] originalArr){
        for(int i = 0; i < originalArr.length / 2; i++){
            int temp = originalArr[originalArr.length - 1 - i];
            originalArr[originalArr.length - 1 - i] = originalArr[i];
            originalArr[i] = temp;
        }
        return originalArr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        // System.out.println(Arrays.toString(reverseBruteForce(arr)));
        System.out.println(Arrays.toString(reverseMoreEfficient(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(reverseMoreEfficient(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }
}



