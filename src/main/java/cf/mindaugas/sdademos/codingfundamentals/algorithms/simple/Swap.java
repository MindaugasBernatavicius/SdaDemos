package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple;

public class Swap {

    public static void main(String[] args) {

        // 0. - Creating a sequence of steps to swap a variable
        Integer first, second;
        first = 1; second = 2;


        System.out.println("Before swaping first was: " + first + " second was: " + second);

        // int temp = second;
        // second = first;
        // first = temp;
        //
        // System.out.println("After swaping first is: " + first + " second is: " + second);

        // swap(first, second);
        // first = getItself(second, second = first);
        System.out.println("After swaping first is: " + first + " second is: " + second);
    }


    // 1. Creating a swap function - NOT POSSIBLE IN JAVA IN A FUCTION, BUT WE CAN DO IT IN PLACE
    public static void swap(Integer first, Integer second){
        Integer temp = second;
        second = first;
        first = temp;
    }

    // 2. Obscure code, not recommended to use:
    public static int getItself(int itself, int dummy)
    {
        return itself;
    }
}
