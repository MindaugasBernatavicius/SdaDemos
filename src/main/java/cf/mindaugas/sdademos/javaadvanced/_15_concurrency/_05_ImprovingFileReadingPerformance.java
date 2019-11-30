package cf.mindaugas.sdademos.javaadvanced._15_concurrency;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class _05_ImprovingFileReadingPerformance {

    static String[] inputFiles = {
            "data/input/1.txt", "data/input/2.txt", "data/input/3.txt", "data/input/4.txt", "data/input/5.txt"};
    static String[] outputFiles = {
            "data/output/1.txt", "data/output/2.txt", "data/output/3.txt", "data/output/4.txt", "data/output/5.txt"};

    public static void main(String[] args) throws IOException, InterruptedException {

        // ... no threads
//        long startTime = System.nanoTime();
//        for (int i = 0; i < inputFiles.length; i++) {
//            Adder adder = new Adder(inputFiles[i], outputFiles[i]);
//            adder.performAddition();
//        }
//        long stopTime = System.nanoTime();
//        System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");

        // ... with threads
        Thread[] threads = new Thread[inputFiles.length];
        long startTime = System.nanoTime();
        for (int i = 0; i < inputFiles.length; i++) {
            AdderR adder = new AdderR(inputFiles[i], outputFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for(Thread t : threads)
            t.join();

        long stopTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");
    }
}

class Adder {
    private String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void performAddition() throws IOException {
        int total = 0;
        String line = null;

        // ... reading
        File fileIn = new File(inFile);
        if (!fileIn.isFile() && !fileIn.createNewFile()) {
            throw new IOException("Error creating new file: " + fileIn.getAbsolutePath());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fileIn))){
            while ((line = br.readLine()) != null )
                total += Integer.parseInt(line);        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // ... writing
        File fileOut = new File(outFile);
        if (!fileOut.isFile() && !fileOut.createNewFile()) {
            throw new IOException("Error creating new file: " + fileOut.getAbsolutePath());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))){
            bw.write("Total: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class AdderR implements Runnable {
    private String inFile, outFile;

    public AdderR(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    @Override
    public void run() {
        try {
            performAddition();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void performAddition() throws IOException {
        int total = 0;
        String line = null;

        // ... reading
        File fileIn = new File(inFile);
        if (!fileIn.isFile() && !fileIn.createNewFile()) {
            throw new IOException("Error creating new file: " + fileIn.getAbsolutePath());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fileIn))){
            while ((line = br.readLine()) != null )
                total += Integer.parseInt(line);        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // ... writing
        File fileOut = new File(outFile);
        if (!fileOut.isFile() && !fileOut.createNewFile()) {
            throw new IOException("Error creating new file: " + fileOut.getAbsolutePath());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))){
            bw.write("Total: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
