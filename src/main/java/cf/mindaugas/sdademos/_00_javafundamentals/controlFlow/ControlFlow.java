package cf.mindaugas.sdademos._00_javafundamentals.controlFlow;

public class ControlFlow {
    public static void main(String[] args) {

        // if

        // switch
        char group = 'S';

        switch (group) {
            case 'A':
                System.out.println("Java Group");
                break;
            case 'B':
                System.out.println("Java + SQL");
                break;
            case 'C':
                System.out.println("C and C++");
                break;
            case 'D':
                System.out.println("Android + Web");
                break;
            case 'F':
                System.out.println("JavaScript");
                break;
            default:
                System.out.println("Groups from A-F only");
        }

    }
}
