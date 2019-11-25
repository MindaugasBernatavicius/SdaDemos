package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple_v2;

public class BinarySearchDemo {

    private static Integer binarySearchArrInts(int[] arr, int targetToFind){
        int leftIdx = 0, rightIdx = arr.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            // check in the middle
            if (arr[midIdx] == targetToFind) return midIdx;

            // If x greater, ignore left half
            if (arr[midIdx] < targetToFind)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }

        return null; // if we reach here, then element was not present
    }

    private static int IllustrateStringCompareTo(String a, String b){
        return a.compareTo(b);
    }

    private static Integer binarySearchArrStrings(String[] arr, String targetToFind) {
        int leftIdx = 0, rightIdx = arr.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            int res = targetToFind.compareTo(arr[midIdx]);
            if (res == 0) return midIdx; // check in the middle

            // If x greater, ignore left half
            if (res > 0)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }

        return null; // if we reach here, then element was not present
    }

    public static void main(String[] args) {
        // Binary search for integers
        // int[] arr = {};
        // int[] arr = { 2 };
        // int[] arr = { 1, 2 };
        // int[] arr = { 1, 2, 500 };
        // int[] arr = { 1, 2, 3, 4, 10, 20, 30, 40, 100, 1050, 1051 };
        // System.out.println(binarySearchArrInts(arr, 2));

        // ... for Strings, let's firs illustrate how to compare strings lexicographically
        // System.out.println(IllustrateStringCompareTo("A", "B"));
        // System.out.println(IllustrateStringCompareTo("A", "A"));
        // System.out.println(IllustrateStringCompareTo("B", "A"));
        // System.out.println(IllustrateStringCompareTo("A", "C"));
        // System.out.println(IllustrateStringCompareTo("AA", "AB"));
        // System.out.println(IllustrateStringCompareTo("AA", "AC"));
        // System.out.println(IllustrateStringCompareTo("AC", "AB"));

        // String[] arr = {};
        String[] arr = { "Albert", "Berto", "Cinnamon", "Dino", "Eric" };
        System.out.println(binarySearchArrStrings(arr, "Dino"));
    }
}
