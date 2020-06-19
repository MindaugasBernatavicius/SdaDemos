package cf.mindaugas.sdademos._02_javaadvanced._01_encapsulation;

import java.text.DecimalFormat;

public class ArrayOfStudents {

    private static double calculateGradeAvg(Student student){
        double sum = 0.0;
        for (int i = 0; i < student.getGrades().length; i++) {
            sum += student.getGrades()[i];
        }
        return sum / student.getGrades().length;
    }

    // 1st:
    // - Create an array of Student objects (each student has to have a firstname, lastname, and an array of grades of type double, getters and setters for all those, and a constructor).
    // - Implement a funtion that accepts a student object and returns the average grade for the student passed in.
    // - Using that function, calculate the average grade for all students and print the result as: "Name: Mindaugas, AVG grade: 7,6"
    // - Round the average grade to two decimal places
    public static void main(String[] args) {

        Student[] students = {
                new Student("Mindaugas", "Bernatavičius", new double[]{9.0, 10.0, 6.0}),
                new Student("Jonas", "Jonaitis", new double[]{7.0, 8.0, 3.0}),
        };

        // Foreach Student in students (array).
        DecimalFormat df = new DecimalFormat("#.##");
        for (Student s : students) {
            System.out.println("Average grade for student: "
                    + s.getFirstName() + ", is: "
                    + Double.valueOf(df.format(calculateGradeAvg(s))));
        }
    }
}


class Student {
    private String firstName;
    private String lastName;
    private double[] grades;

    public Student(String firstName, String lastName, double[] grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }
}
