import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PrintInPlace {
    public static void main(String[] args) throws IOException {

        // 1. Scanner
        // Scanner s = new Scanner(System.in);

        // 2. System.console
        // To use console, you need to lauch the program in the cmd
        // Console console = System.console();

        // 3. http://www.source-code.biz/snippets/java/RawConsoleInput/RawConsoleInput.java
        // http://www.source-code.biz/snippets/java/RawConsoleInput/
        // https://stackoverflow.com/a/30008252/1964707

        Random r = new Random();
        char answer = '\0';

        System.out.println("Press q at any time to quit the game");

        while (true){
            int randomInt = r.nextInt(10);
            // 1.
            System.out.print("Is number: " + randomInt + " divisible by 3?: ");
            // answer = s.next("[yn]");

            // 2.
            // answer = console.readLine("\r\b\b\b\bIs number: " + randomInt + " divisible by 3? ==> ");

            // 3.
            answer = (char)RawConsoleInput.read(true);
            while (answer != 'y' || answer != 'n' || answer != 'q'){
                // System.out.print((int)answer);
                answer = (char)RawConsoleInput.read(false);
            }
            // System.out.print(answer);


            // answer.equalsIgnoreCase("n")
            if(randomInt % 3 == 0 && answer == 'y')
                continue;
            else if(randomInt % 3 != 0 && answer == 'n')
                continue;
            else {
                if(answer != 'q')
                    System.out.println("You lost");
                break;
            }
        }
    }
}
