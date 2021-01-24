package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.simple;

public class SumOfArray {

    public static void main(String[] args) {

        // create a function that sums (adds)
        // all elements inside an array

        int[] arr = {10, 1, 2, 3, 0};
        System.out.println("Sum: " + sumOfArray(arr));
    }

    private static int sumOfArray(int[] arr) {
        // can't assign 0 in this case,
        // since it would not work when
        // the array would consist of only
        // possitive numbers
        int sum = arr[0];
        // caution: do not init the counter to 0
        // as you would be double counting of 1st elem.

        // Recall that these are equivalent:
        // i = i + 1; i++; ++i; i += 1
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i]; // equivalent to this expression: sum = sum + arr[i];
        }
        return sum;
    }
}
