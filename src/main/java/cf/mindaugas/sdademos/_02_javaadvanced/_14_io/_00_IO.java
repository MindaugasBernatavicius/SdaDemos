package cf.mindaugas.sdademos._02_javaadvanced._14_io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _00_IO {
    public static void main(String[] args) {
        // Creating a file object that will represent a file object in programs memory
        File absoluteFile = new File("C:/myDirectory/f.csv");
        File relativeFile = new File("files/myFile.txt");
        // escape sequences [\n, \r, \t, \s, ]
        File mavenFile = new File("target\\classes\\textFiles\\x.csv");

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

        // More complex example without try with resources
        try {
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
                    if(fileLine.split(",")[i] != null){
                        if(i == 0){
                            id = fileLine.split(",")[i];
                        } else if(i == 1){
                            name = fileLine.split(",")[i];
                        } else if(i == 2) {
                            age = fileLine.split(",")[i];
                        }
                    }
                }

                if(!id.isEmpty() && !age.isEmpty()){
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
}

class Human implements Comparable<Human>{
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
