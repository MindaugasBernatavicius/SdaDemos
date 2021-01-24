package cf.mindaugas.sdademos._02_javaadvanced._11_collections;

import java.util.ArrayList;
import java.util.List;

public class Excercises {

    public static void multiplicationTable() {

        // ... initialize
        List<List<Integer>> multiplicationTable = new ArrayList<>();

        // ... generate numbers
        ArrayList<Integer> temp;
        for (int i = 0; i < 10; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < 10; j++)
                temp.add(i * j);
            multiplicationTable.add(temp);
        }

        // ... print them out in a tabular form
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++)
                System.out.printf("%3s|", multiplicationTable.get(i).get(j));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        multiplicationTable();
    }
}
