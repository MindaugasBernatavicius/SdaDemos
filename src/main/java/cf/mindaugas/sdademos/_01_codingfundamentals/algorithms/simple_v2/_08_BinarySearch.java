package cf.mindaugas.sdademos._01_codingfundamentals.algorithms.simple_v2;

import java.util.Comparator;

public class _08_BinarySearch {

    /**
     * binarySearchArrInts - search for a given element of interest in array of ints
     * @param arr
     * @param targetToFind
     * @return the index at which the element was found, or null - if it was not
     */
    private static Integer binarySearchArrInts(int[] arr, int targetToFind){
        int leftIdx = 0, rightIdx = arr.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            // check in the middle
            if (arr[midIdx] == targetToFind) return midIdx;

            // If x greater, ignore left half
            if (arr[midIdx] < targetToFind)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }
        return null; // if we reach here, then element was not present
    }

    private static int IllustrateStringCompareTo(String a, String b){
        return a.compareTo(b);
    }

    /**
     * binarySearchArrStrings - search for a given element of interest in array of Strings
     * @param arr
     * @param targetToFind
     * @return the index at which the element was found, or null - if it was not
     */
    private static Integer binarySearchArrStrings(String[] arr, String targetToFind) {
        int leftIdx = 0, rightIdx = arr.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            int res = targetToFind.compareTo(arr[midIdx]);
            if (res == 0) return midIdx; // check in the middle

            // If x greater, ignore left half
            if (res > 0)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }

        return null; // if we reach here, then element was not present
    }

    private static Integer binarySearchArrStudents(Student[] students, Student targetToFind){
        int leftIdx = 0, rightIdx = students.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            int res = targetToFind.compareTo(students[midIdx]);
            if (res == 0) return midIdx; // check in the middle
            System.out.println("RES:" + res);

            // If x greater, ignore left half
            if (res > 0)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }

        return null; // if we reach here, then element was not present
    }

    private static Integer binarySearchArrStudentsWComparator(
            Student[] students, Student targetToFind, StudentComparator comparator)
    {
        int leftIdx = 0, rightIdx = students.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            int res = comparator.compare(targetToFind, students[midIdx]);
            if (res == 0) return midIdx; // check in the middle

            // If x greater, ignore left half
            if (res > 0)
                leftIdx = midIdx + 1;
            else // If x is smaller, ignore right half
                rightIdx = midIdx - 1;
        }

        return null; // if we reach here, then element was not present
    }

    public static void main(String[] args) {
        // Binary search for integers
        // int[] arr = {};
        // int[] arr = { 2 };
        // int[] arr = { 1, 2 };
        // int[] arr = { 1, 2, 500 };
        // int[] arr = { 1, 2, 3, 4, 10, 20, 30, 40, 100, 1050, 1051 };
        // System.out.println(binarySearchArrInts(arr, 2));

        // ... for Strings, let's firs illustrate how to compare strings lexicographically
        // System.out.println(IllustrateStringCompareTo("A", "B"));
        // System.out.println(IllustrateStringCompareTo("A", "A"));
        // System.out.println(IllustrateStringCompareTo("B", "A"));
        // System.out.println(IllustrateStringCompareTo("A", "C"));
        // System.out.println(IllustrateStringCompareTo("AA", "AB"));
        // System.out.println(IllustrateStringCompareTo("AA", "AC"));
        // System.out.println(IllustrateStringCompareTo("AC", "AB"));

        // String[] arr = {};
        // String[] arr = { "Albert", "Brother", "Cinnamon" };
        // System.out.println(binarySearchArrStrings(arr, "Brother"));

        // ... for Array of objects
        // Student[] arr = {
        //         new Student("Mindaugas", 9.1),
        //         new Student("Jonas", 9.5)
        // };

        Student[] arr = {
                new Student("Mindaugas", 9.0),
                new Student("Jonas", 9.1),
                new Student("Pranas", 9.2)
        };

        System.out.println(
                binarySearchArrStudents(arr, new Student("Pranas", 9.2)));

        // System.out.println(
        //         binarySearchArrStudentsWComparator(
        //                 arr, new Student("Pranas", 9.1), new StudentComparator()));
    }
}

class Student implements Comparable<Student>{
    private String name;
    private double averageGrade;

    public Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student otherStudent) {
        // return positive integer, if the current object is greater other.
        if(this.getAverageGrade() < otherStudent.getAverageGrade())
            return 1;
        // negative integer, if the current object is less than other.
        else if(this.getAverageGrade() > otherStudent.getAverageGrade())
            return -1;
        // zero, if the current object is equal to other.
        else
            return 0;

//         // TODO :: implement compareTo method, that compares by name and grade
//         if(this.getAverageGrade() > otherStudent.getAverageGrade())
//             return 1;
//         else if(this.getAverageGrade() < otherStudent.getAverageGrade())
//             return -1;
//         else {
//             if(this.getName().compareTo(otherStudent.getName()) > 0)
//                 return 1;
//             else if(this.getName().compareTo(otherStudent.getName()) < 0)
//                 return -1;
//             else
//                 return 0;
//         }
    }
}

class StudentGradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        // return positive integer, if the current object is greater other.
        if(o1.getAverageGrade() > o2.getAverageGrade())
            return 1;
        // negative integer, if the current object is less than other.
        else if(o1.getAverageGrade() < o2.getAverageGrade())
            return -1;
        // zero, if the current object is equal to other.
        else
            return 0;
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAverageGrade() > o2.getAverageGrade())
            return 1;
        else if(o1.getAverageGrade() < o2.getAverageGrade())
            return -1;
        else {
            if(o1.getName().compareTo(o2.getName()) > 0)
                return 1;
            else if(o1.getName().compareTo(o2.getName()) < 0)
                return -1;
            else
                return 0;
        }
    }
}
