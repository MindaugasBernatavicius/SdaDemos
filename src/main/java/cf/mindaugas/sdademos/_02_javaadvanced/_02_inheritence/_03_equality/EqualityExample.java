package cf.mindaugas.sdademos._02_javaadvanced._02_inheritence._03_equality;

public class EqualityExample {

    private static boolean contains(Student[] students, Student student){
        boolean contains = false;
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(student)){
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(34546474808L, "Mindaugas", "Pranaitis"),
                new Student(36546474444L, "Saulius", "Prūsaitis"),
        };


        Student studentToSearchFor = new Student(34546474808L, "Benas", "Pranaitis");
        System.out.println(contains(students, studentToSearchFor));
    }
}

class Student {
    private long ssn;
    private String firstName;
    private String lastName;

    public Student(long ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
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

    @Override
    public boolean equals(Object o) {
        // tikriname ar o yra tas pat objektas
        if (this == o) return true;

        // tikriname ar priklauso objektai taip pačiai klasei, jei nei - tai automatiškai false
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (ssn != student.ssn){
            return false;
        } else {
            return true;
        }
    }
}
