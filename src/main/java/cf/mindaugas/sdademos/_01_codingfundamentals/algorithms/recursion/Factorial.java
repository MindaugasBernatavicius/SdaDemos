package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.recursion;

public class Factorial {
    public static void main(String args[]) {
        System.out.println(factorialIterative(6));
        System.out.println(factorialRecursive(6));
    }

    static int factorialIterative(int in) {
        int fact = 1;
        for (int i = 1; i <= in; i++) {
            // fact = fact * i;
            fact *= i;
        }
        return fact;
    }

    static int factorialRecursive(int in) {
        int fact = in;

        // 1 - stopping condition
        if (in == 1)
            return in;

        // 2 - logic part
        fact = fact * factorialRecursive(in - 1);

        return fact;
    }
}
