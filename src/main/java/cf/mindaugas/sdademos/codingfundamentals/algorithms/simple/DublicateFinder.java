package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple;

public class DublicateFinder {

    public static void main(String[] args){
        int i; // declaration
        i = 0; // initialization
        int j = 0; // combined

        // 1 - define test array
        // int[] testArr = {2, 4, 7, 4, 1, 7};
        int[] testArr = {2, 4, 7, 4, 1, 7, 7}; // buggy with naive implementation

        // 4 - call the function
        DublicateFinder df = new DublicateFinder();
        int dubNum = df.countDubs(testArr);

        System.out.println("Number of dublicates: " + dubNum);

        int[] dubs = df.getAllDubs(testArr);
        for (int k = 0; k < dubs.length; k++){
            System.out.print(dubs[k] + " ");
        }
    }

    public int countDubsNaive(int[] arr) {
        // Count how many dublicates in total are there
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            // critical part to not double count the previous elements: i + 1
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countDubs(int[] arr) {
        // Initialize tracker for already counted values
        int[] counted = new int[arr.length];

        // Count how many dublicates in total are there
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && counted[j] != 1) {
                    count++;
                    counted[j] = 1;
                }
            }
        }
        return count;
    }

    public int[] getAllDubs(int[] arr){
        // Initialize tracker for already counted values
        int[] counted = new int[arr.length];

        // Count how many dublicates in total are there
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && counted[j] != 1) {
                    count++;
                    counted[j] = 1;
                }
            }
        }

        // We can print the counted array to
        // see if it matches our expectations
        // for (int k = 0; k < counted.length; k++){
        //     System.out.print(counted[k] + " ");
        // }
        // System.out.println();


        int[] dubs = new int[count];
        int x = 0;
        for(int z = 0; z < arr.length; z++) {
            if(counted[z] == 1){
                dubs[x] = arr[z];
                x++;
            }
        }

        return dubs;
    }
}