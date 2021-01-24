import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.util.Random;

// TODO :: add clock for each attempt in each level, add levels, add progress bar for each level

public class PrintInPlaceJLine {

    public static void main(String[] args) throws IOException {

        Random r = new Random();
        char answer = '\0';

        // https://stackoverflow.com/a/47554285/1964707
        Terminal terminal = TerminalBuilder
                .builder().jna(true).system(true).build();

        System.out.println("Press q at any time to quit the game");

        terminal.enterRawMode();
        NonBlockingReader reader = terminal.reader();

        while (true) {
            int randomInt = r.nextInt(10);
            System.out.print("\rIs number: " + randomInt + " divisible by 3?: ");

            // https://github.ncom/jline/jline3
            answer = (char) reader.read();
            if (answer == '\n')
                answer = (char) reader.read();


            if (randomInt % 3 == 0 && answer == 'y')
                continue;
            else if (randomInt % 3 != 0 && answer == 'n')
                continue;
            else {
                if (answer != 'q')
                    System.out.println("You lost");
                break;
            }
        }


        reader.close();
        terminal.close();
    }
}
