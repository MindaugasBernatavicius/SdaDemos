package cf.mindaugas.sdademos.javaadvanced._14_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_NIO {
    public static void main(String[] args){
        // Writing in NIO
        Path filePath = Paths.get("data2/example.txt");
        Path dir = Paths.get("data2");

        try {
            if(!Files.isDirectory(dir)){
                Files.createDirectory(Paths.get("data2"));
            }
            Files.write(filePath, Arrays.asList("line1", "line2", "line3"));
            // Files.write(filePath, Arrays.asList("line1", "line2", "line3"), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
        }

        // Read in IO (Old)
        File f = new File("data/example.txt");
        List<String> linesRead = new ArrayList<>();
        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while((line = br.readLine()) != null){
                linesRead.add(line);
            }
        } catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        } catch (IOException ex2){
            ex2.printStackTrace();
        }
        System.out.println(linesRead);

        // Read in NIO
        try {
            List<String> linesReadNew = Files.readAllLines(filePath);
            System.out.println(linesReadNew);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
