package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple_v2;

public class _02_LinearFunction {

    // Ref: https://alg24.com/en/algorithms/index.php?option=com_content&view=article&id=292:algorithm-for-solving-linear-equation-ax-b-0&catid=87:algorytmy&lang=en-GB&Itemid=1197
    public static void solve(int a, int b){
        // 1. IF a != 0, the zero place is -b/a
        if(a != 0)
            System.out.println(-b / a);

        // 2. IF a == 0 AND b != 0, no zero places
        if(a == 0 && b != 0)
            System.out.println("No zeros");

        // 3. IF a == 0 AND b == 0, every number is a zero place
        if(a == 0 && b == 0)
            System.out.println("Every number");
    }

    public static void main(String[] args) {
        // f(x) = ax + b ==> 0 = 5x + 5
        _02_LinearFunction.solve(5, 5);
    }
}
