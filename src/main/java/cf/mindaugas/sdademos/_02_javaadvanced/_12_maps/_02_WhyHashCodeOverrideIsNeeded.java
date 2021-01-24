package cf.mindaugas.sdademos._02_javaadvanced._12_maps;

import java.util.*;

public class _02_WhyHashCodeOverrideIsNeeded {
    public static void main(String[] args) {
        // // 1. List example - w/ only equals() overridden
        // Student alex = new Student(1, "Alex");
        // List<Student> studentsList = new ArrayList<>();
        // studentsList.add(alex);
        // System.out.println("Arraylist size = " + studentsList.size());
        // System.out.println(studentsList);
        // System.out.println("Arraylist contains Alex = " + studentsList.contains(new Student(1, "Alex")));
        // // ... we see that .contains() works fine with lists. Having equals() overridden is enough

        // // 1. Set example
        // Student alex1 = new Student(1, "Alex");
        // Student alex2 = new Student(1, "Alex");
        // Set<Student> studentsSet = new HashSet<>();
        // studentsSet.add(alex1);
        // studentsSet.add(alex2);
        // System.out.println("HashSet size = " + studentsSet.size());
        // System.out.println(studentsSet);
        // System.out.println("HashSet contains Alex = " + studentsSet.contains(new Student(1, "Alex")));

        // 2. Map example
        Map<Student, Student> studentToBestFriendMap = new HashMap<>();
        studentToBestFriendMap.put(new Student(1, "Alex"), new Student(2, "Jonas"));
        studentToBestFriendMap.put(new Student(3, "Pranas"), new Student(4, "Mindaugas"));

        // get best friend for Alex
        System.out.println(studentToBestFriendMap.get(new Student(1, "Alex")));
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
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

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == null) return false;
    //     if (!(obj instanceof Student))
    //         return false;
    //     if (obj == this)
    //         return true;
    //     return this.getId() == ((Student) obj).getId();
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        if (id != student.id) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" + id + " : " + name + "}";
    }
}
