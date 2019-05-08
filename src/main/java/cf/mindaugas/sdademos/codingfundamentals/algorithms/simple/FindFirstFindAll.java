package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple;

public class FindFirstFindAll {
    public static void main(String[] args) {
        int[] arr = {10,1,2,3,0,7};

        findFirstPrime(arr);
        findAllPrimes(arr);

    }

    private static void findFirstPrime(int[] arr) {
        for(int i = 0; i < arr.length; i++ ){
            if(isPrime(arr[i])){
                System.out.println("First prime: " + arr[i]);
                break;
            }
        }
    }

    private static void findAllPrimes(int[] arr) {
        System.out.print("All primes: ");
        for(int i = 0; i < arr.length; i++ ){
            if(isPrime(arr[i])){
                System.out.print(arr[i]);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
