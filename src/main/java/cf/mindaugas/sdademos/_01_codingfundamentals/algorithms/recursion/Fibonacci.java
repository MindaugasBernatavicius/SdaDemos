package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.recursion;

public class Fibonacci {
    public static void main(String args[]) {
        // System.out.println(factorialIterative(6));
        // System.out.println(factorialRecursive(6));
        // System.out.println("0 --> " + fibRecursive(0));
        // System.out.println("1 --> " + fibRecursive(1));
        // System.out.println("2 --> " + fibRecursive(2));
        // System.out.println("3 --> " + fibRecursive(3));
        // System.out.println("4 --> " + fibRecursive(4));
        // System.out.println("5 --> " + fibRecursive(5));
        // System.out.println("6 --> " + fibRecursive(6));
        System.out.println("6 --> " + fibRecursive(6));
        System.out.println("6 --> " + fibIterative(6));

        // 1st. micro-benching
        // int fibRes;
        // int input = 10;
        // long startTime = System.nanoTime();
        // fibRes = fibRecursive(10);
        // long endTime = System.nanoTime();
        // System.out.println("The fibRecursive(" + input + ") call took: " + (endTime - startTime) + "ns");


        // 2nd. micro-benching
        long startTime, endTime;
        int fibRes;
        for(int input = 1; input < 15; input++){
            startTime = System.nanoTime();
            fibRes = fibRecursive(input);
            endTime = System.nanoTime();
            System.out.println("The fibRecursive(" + input + ") call took: " + (endTime - startTime) + "ns");
        }
    }
    /**
     * Iterative implementation for nth fibonacci number
     * Time complexity - O(n)
     * Space complexity - O(1)
     *
     * @param n
     * @return
     */
    static int fibIterative(int n) {
        if(n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        return fib;
    }

    /**
     * Recursive implementation for nth fibonacci number
     * Time complexity - O(n)
     * Space complexity - O(n)
     *
     * @param n
     * @return
     */
    static int fibRecursive(int in){
        int fib = in;

        // stoping condition
        if(in == 0)
            return 0;

        if(in <= 1)
            return 1;

        // logic
        fib = fibRecursive(in - 1) + fibRecursive(in - 2);
        return fib;
    }
}
