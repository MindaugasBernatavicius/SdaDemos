package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple;

public class SumOfArray {

    public static void main(String[] args) {
        int[] arr = {10,1,2,3,0};
        System.out.println("Min:" + sumOfArray(arr));
    }

    private static int sumOfArray(int[] arr) {
        int sum = arr[0];
        // caution: do not init the counter to 0
        // as you would be double counting of 1st elem.

        // Recall that these are equivalent:
        // i = i + 1; i++; ++i; i += 1
        for(int i = 1; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}
