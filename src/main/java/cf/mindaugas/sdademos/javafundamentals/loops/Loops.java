package cf.mindaugas.sdademos.javafundamentals.loops;

import java.util.Arrays;

public class Loops {

    public static void main(String[] args) {

        // Loops alphabet
        char c = 'a';//97

        while(c <= 'z'){
            System.out.print(c);
            c++;
        }

        System.out.println("\n---------------------");
        c = 'a';
        do {
            System.out.print(c);
            c++;
        } while(c <= 'z');

        System.out.println("\n---------------------");
        for(c = 'a'; c <= 'z'; c++){
            System.out.print(c);
        }

       // for loop - break and continue
        for(int i=0; i <= 10; i++){
            if(i == 6){ break; }
            System.out.println("i: " + i);
        }

        System.out.println("==================");

        for(int i = 0; i <= 10; i++){
            if(i % 3 == 0){ continue; }
            System.out.println("i: " + i);
        }

        // nested loops - all combinations printing is a common usage
        for(int j = 1; j<=10; j++) {
            for (int i = 1; i <= 10; i++) {
                if((i==1) || (i==10)){
                    System.out.print("# ");
                } else if((j==1) || (j==10)){
                    System.out.printf("# ");
                } else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        // enhanced for loop
        int[] arrayInt = {10,20,30,40,50};
        String[] arrayStr = {"first", "second", "third", "fourth", "fifth" };

        int len = arrayInt.length;

        for(int i =0; i<len; i++){

            System.out.println(arrayInt[i] + " ... " + arrayStr[i]);
        }

        System.out.println("======================================");

        for ( int i : arrayInt) {
            System.out.println(i);
        }

        //same for String arrays
        System.out.println("======================================");

        String str = Arrays.toString(arrayInt);//return type is String & import java.util.Arrays;
        System.out.println(str);

        System.out.println("======================================");

        String line = "first,second,third,fourth,fifth";

        String[] arrayline = line.split(",");

        for ( String i : arrayline) {
            System.out.println(i);
        }
    }
}
