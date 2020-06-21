package cf.mindaugas.sdademos._02_javaadvanced._04_composition;

public class CompositionExample {
    public static void main(String[] args) {
        // 1.
        // FullName fn = new FullName("X", "AE A-XII", "MUSK");
        // Person person1 = new Person(fn, 22);

        // 2.
        Person person1 = new Person(new FullName("X", "AE A-XII", "MUSK"), 22);
        System.out.println(person1.getFullname() + ", age: " + person1.getAge());
    }
}

class Person {
    private FullName fullname;
    private int age;

    public Person(FullName fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    public FullName getFullname() {
        return fullname;
    }

    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
