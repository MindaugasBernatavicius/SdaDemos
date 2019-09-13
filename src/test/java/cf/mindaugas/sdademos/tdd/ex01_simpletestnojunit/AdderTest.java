package cf.mindaugas.sdademos.tdd.ex01_simpletestnojunit;

public class AdderTest {
    public static void main(String[] args){
        int result = Adder.add(1, 6);

        if(result == 7)
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}
