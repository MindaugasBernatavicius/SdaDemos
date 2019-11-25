package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple_v2;

public class _06_SecondSmallestInArray {

    private static int getSecondSmallestNaive(int[] arr){
        int min = arr[0];
        int secondMin = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            }
        }
        return secondMin;
    }

    private static int getSecondSmallest(int[] arr){
        int min = arr[0];
        int secondMin = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] != min) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }

    public static void main(String[] args) {
        // Create and implement an algorithm
        // which will find the second smallest value in an array

        // if the second smallest comes after the smallest
        // we will not find it with the naive solution
        int[] arr1 = {44, 5, 44, 3, 2};
        int[] arr2 = {44, 5, 44, 4, 2, 3, 22, 6};

        // when array min is the first number, the algorithm will not work
        // (possible workaround - use Integer class with null, or Integer.MIN_VALUE)
        // int[] arr3 = {1, 5, 44, 4, 2, 3, 22, 6};

        System.out.println(getSecondSmallestNaive(arr1));
        System.out.println(getSecondSmallestNaive(arr2));
        // System.out.println(getSecondSmallestNaive(arr3));
    }

}
