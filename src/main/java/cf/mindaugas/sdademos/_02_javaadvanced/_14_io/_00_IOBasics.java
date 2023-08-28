package cf.mindaugas.sdademos._02_javaadvanced._14_io;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class _00_IOBasics {
    public static void _00_representingAFile(){
        // Creating a file object that will represent a file object in programs memory
        File absoluteFile = new File("C:/myDirectory/f.csv");
        File relativeFile = new File("files/myFile.txt");
        // escape sequences [\n, \r, \t, \s, \\]
        File mavenFile = new File("target\\classes\\textFiles\\x.csv");

        // How can you reach that file if you know where it's stored? You need to know where Java is executing.
        // This is called the WORKING DIRECTORY of your application (also a general term, not Java specific)
        // 2 ways to find out the WORKING DIRECTORY:
        // ... - take an educated guess
        // ... - get current directory with Java
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void _01_ReadingWithIOCharByChar(){
        File relativeFile = new File("myFile.txt");
        try (FileReader fileReader = new FileReader(relativeFile)) {
            int character;
            while ((character = fileReader.read()) != -1){
                // System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static void _02_ReadingWithIOBuffered() {
        // ... try-with-resources (autocloseable), w/o it write this: https://www.guru99.com/buffered-reader-in-java.html
        File relativeFile = new File("myFile.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(relativeFile))) {
            // while(true)
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                // System.out.println(fileLine);
            }
        }
        // .. which code throws exception? FileReader and bufferedReader.readLine()
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _03_BenchmarkingBufferedVNonBufferedIO() {
        try {
            var opt = new OptionsBuilder()
                    .include(_00_IOBasics.class.getSimpleName())
                    .forks(1)
                    .warmupIterations(2)
                    .measurementIterations(5)
                    .build();
            new Runner(opt).run();
        } catch (RunnerException e) {
            throw new RuntimeException(e);
        }

        // With println() commented out
        // Benchmark                                 Mode  Cnt      Score      Error  Units
        // _00_IOBasics._01_ReadingWithIOCharByChar  avgt   20  46835,588 ± 1463,895  ns/op
        // _00_IOBasics._02_ReadingWithIOBuffered    avgt   20  47310,078 ± 1087,319  ns/op

        // With println() uncommented (you now start benching the printlines!!!)
        // Benchmark                                 Mode  Cnt       Score        Error  Units
        // _00_IOBasics._01_ReadingWithIOCharByChar  avgt    5  286893,651 ± 144810,769  ns/op
        // _00_IOBasics._02_ReadingWithIOBuffered    avgt    5  147281,092 ±  17742,908  ns/op

        // Try bigger files, files that do not fit into memory
    }

    public static void _04_Writing() {
        File absoluteFile = new File("C:\\Users\\Mindaugas\\Desktop\\Projects\\SdaDemos\\file2.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(absoluteFile))) {
            // 0. Adding a line (without newline)
            String fileLine = "file line";
            bw.write(fileLine);

            // // 1. ... with newline
            // String fileLine2 = "file line\n";
            // bw.write(fileLine2);
            // bw.write("vsdvddvd");
            // bw.newLine();
            // bw.write("vsdvddvd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _05_Appending() {
        File absoluteFile = new File("C:\\Users\\Mindaugas\\Desktop\\Projects\\SdaDemos\\file2.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absoluteFile, true))) {
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void _06_MoreComplexExampleInitObjectHandleMissingValues() {
        try {
            File mavenFile = new File("target\\classes\\textFiles\\x.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(mavenFile));

            // // 0.
            // String fileLine = bufferedReader.readLine();
            // while (fileLine != null) {
            //     System.out.println(fileLine);
            //     fileLine = bufferedReader.readLine();
            // }

            // 1.
            String fileLine;
            List<Human> people = new ArrayList<>();

            // 2. Simple version for reading file line by line
            System.out.println("------------- Simple version for reading file line by line ------------");
            while ((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);
            }
            System.out.println("----------------------------------------------------------------------");

            // 2. Some logic to handle missing values
            System.out.println("------------- Some logic to handle missing values ------------");
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(mavenFile));
            String id = "";
            String name = "";
            String age = "";
            while ((fileLine = bufferedReader2.readLine()) != null) {
                String[] stringParts = fileLine.split(",");
                for (int i = 0; i < stringParts.length; i++) {
                    if (fileLine.split(",")[i] != null) {
                        if (i == 0) {
                            id = fileLine.split(",")[i];
                        } else if (i == 1) {
                            name = fileLine.split(",")[i];
                        } else if (i == 2) {
                            age = fileLine.split(",")[i];
                        }
                    }
                }

                if (!id.isEmpty() && !age.isEmpty()) {
                    Human p = new Human(Integer.parseInt(id), name, Integer.parseInt(age));
                    people.add(p);
                }
                id = name = age = "";
            }

            System.out.println(people);

            int sum = 0;
            for (int i = 0; i < people.size(); i++)
                sum += people.get(i).age;

            System.out.println("Average age: " + sum / people.size());

            System.out.println("Let's sort the objects");
            System.out.println(people);
            Collections.sort(people);
            System.out.println(people);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // _00_representingAFile();
        // _01_ReadingWithIOCharByChar();
        // _02_ReadingWithIOBuffered();
        // _03_BenchmarkingBufferedVNonBufferedIO();
        // _04_Writing();
        // _05_Appending();
        // _06_MoreComplexExampleInitObjectHandleMissingValues();
    }
}


class Human implements Comparable<Human> {
    int id;
    String name;
    int age;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" + id + " : " + name + " : " + age + "}";
    }

    @Override
    public int compareTo(Human human) {
        return Integer.compare(this.age, human.age);
    }
}