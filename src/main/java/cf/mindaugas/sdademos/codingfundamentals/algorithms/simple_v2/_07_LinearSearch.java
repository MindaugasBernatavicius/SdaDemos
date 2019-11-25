package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple_v2;

public class _07_LinearSearch {

    public static int contains(int[] arr, int targetWeAreSearchingFor){
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == targetWeAreSearchingFor){
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(contains(new int[]{1, 2, 3}, 5));
        System.out.println(contains(new int[]{1, 2, 7, 5, 8}, 5));
        System.out.println(contains(new int[]{7, 0, 3, 8, 2}, 8));
    }
}
