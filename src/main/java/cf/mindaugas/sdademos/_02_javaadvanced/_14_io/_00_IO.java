package cf.mindaugas.sdademos._02_javaadvanced._14_io;

import java.io.*;

public class _00_IO {
    public static void main(String[] args) {
        File absoluteFile = new File("C:/myDirectory/myFile.txt");
        File relativeFile = new File("myFile.txt");

        // 0. Where should we create / store that file?
        // ... two ways to find out:
        // ... - take an educated guess
        // ... - get current directory with Java
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Reading with old io
        // ... using try-with-resources (autocloseable), withut using try-with-resources we would need to write this:
        // ... https://www.guru99.com/buffered-reader-in-java.html
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(relativeFile))) {
            String fileLine;
            // while(true)
            while ((fileLine = bufferedReader.readLine()) != null) { // \n
                System.out.println(fileLine);
            }
        }
        // .. which code throws exception? FileReader and bufferedReader.readLine()
        catch (IOException e) {
            e.printStackTrace();
        }

        // Writing with old io
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(absoluteFile))) {
            // 0. Adding a line (without newline)
            String fileLine = "file line";
            bw.write(fileLine);

            // 1. ... with newline
            String fileLine2 = "file line\n";
            bw.write(fileLine2);
            bw.write("vsdvddvd");
            bw.newLine();
            bw.write("vsdvddvd");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Appending with old io
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absoluteFile, true))) {
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
