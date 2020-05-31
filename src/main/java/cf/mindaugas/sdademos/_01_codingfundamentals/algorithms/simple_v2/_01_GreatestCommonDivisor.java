package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.simple_v2;

public class _01_GreatestCommonDivisor {

    // More info: http://512algorithms.blogspot.com/
    private static int gcdEuclid(int n1, int n2) {
        if (n1 == 0) return n2;
        while (n1 != n2){
            if (n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }
        return n1;
    }

    public static void main(String[] args) {
        System.out.println(gcdEuclid(18, 24));
        System.out.println(gcdEuclid(10, 15));
    }
}
