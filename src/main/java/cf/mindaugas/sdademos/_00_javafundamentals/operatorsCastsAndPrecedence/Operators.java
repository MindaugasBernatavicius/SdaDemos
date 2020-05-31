package cf.mindaugas.sdademos._00_javafundamentals.operatorsCastsAndPrecedence;

public class Operators {

    public static void main(String[] args) {

// ASSIGNMENT OPERATORS: =, +=, -=, *=, /=

// RELATIONAL OPERATORS: <, <=, >, >=, ==, !=

// ARITHMETIC OPERATORS: +, -, *, /, %, ++, --

// LOGICAL OPERATORS: &, |, ^, !, &&, ||

// BITWISE OPERATORS: &, |, ^, ~

// BIT-SHIFTING OPERATORS: <<, >>, >>>

// CONDITIONAL OPERATOR (TERNARY): ? :

// INSTANCEOF OPERATOR: instanceof

        int car1speed = 140;
        int car2speed = 150;
        String text = null;


        if (car1speed > car2speed){
            text="Congratulations CAR-1... you won!";
        }
        else if (car2speed > car1speed) {
            text = "Congratulations CAR-2... you won!";
        }
        System.out.println("Message: " + text);
        System.out.println("=================");

        text = (car1speed > car2speed)? "Congratulations CAR-1... you won!" : "Congratulations CAR-2... you won!" ;
        System.out.println("Message: " + text);
    }
}
