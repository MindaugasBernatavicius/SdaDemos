package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple_v2;

import java.util.Arrays;

public class _05_ReverseArray {
    public static void main(String[] args) {

        int[] data = {1, 2, 3};

        for(int i = 0; i < data.length / 2; i++){
            int temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(data));
    }
}
