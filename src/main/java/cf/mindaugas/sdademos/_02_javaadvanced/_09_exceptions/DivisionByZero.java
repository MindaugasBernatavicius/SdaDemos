package cf.mindaugas.sdademos._02_javaadvanced._09_exceptions;

public class DivisionByZero {

    public static void main(String[] args) {
        // try{
        //     int i = 10; int j = 1;
        //     System.out.println(i / j);
        //     System.out.println("... still inside try{}"); //
        // } catch (Exception e){
        //     System.out.println(e.getMessage());
        //     System.out.println(e.getStackTrace());
        // } finally {
        //     System.out.println("Finally block executed!");
        // }

        // Calculator.divide(10, 0);

        try {
            System.out.println(Calculator.divide(10, 0));
        } catch (Exception e) {
            System.err.println("Exception happended!");
        } // ... we can also do nothing


        // Note: you should generally throw checked exceptions manually:
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
    }
}

class Calculator {
    static double divide(int first, int second) throws Exception {
        if (second == 0)
            throw new Exception("Please don't divide by zero, m8!");
        return first / second;
    }
}


// TODO :: create a custom exception
