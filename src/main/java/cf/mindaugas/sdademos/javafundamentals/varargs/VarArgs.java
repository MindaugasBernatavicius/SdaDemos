package cf.mindaugas.sdademos.javafundamentals.varargs;

public class VarArgs{

    static void display(String... values){
        System.out.println("display method invoked ");

        // all arguments can be printed using for loop
    }

    public static void main(String args[]){
        display();//zero arguments
        display("my","name","is","varargs"); //four arguments
    }
}