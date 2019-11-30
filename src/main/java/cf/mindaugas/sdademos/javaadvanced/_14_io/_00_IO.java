package cf.mindaugas.sdademos.javaadvanced._14_io;

import java.io.*;

public class _00_IO {

    public static void main(String[] args) {
        File absoluteFile = new File("C:/myDirectory/myFile.txt");
        File relativeFile = new File("myFile.txt");

        // Reading with old io
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(relativeFile))) {
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Witting with old io
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absoluteFile))) {
            String fileLine = "file line";
            bufferedWriter.write(fileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Appending with old io
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(relativeFile, true))) {
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
