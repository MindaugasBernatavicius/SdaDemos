package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.simple;

public class FindMinAndMax {

    public static void main(String[] args) {
        int[] arr = {10,1,2,3,0};
        System.out.println("Min:" + findMin(arr));
        System.out.println("Max:" + findMax(arr));
    }

    public static int findMin(int[] arr){
        // if the currently presumed minimum
        // is bigger than the currently checked number
        // we know that we need to change the minimum
        // for that number


        // caution: do not minitialize min to 0! Why?
        // Because what if the real minimum is bigger than 0?
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
