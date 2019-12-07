package cf.mindaugas.sdademos.design.generalprinciples;

public class _03_LoD {
    public static void main(String[] args) {
        Human h1 = new Human(
                new Name("Mindaugas", "Jonas", "Bernatavičius"), 30);

        System.out.println(h1.getName().getFirstName());

        // ... instead do this ... however this introduces tight coupling and dublication
        // ... what if you had to add all the getters for all the fields
        System.out.println(h1.getFirstName());

        // ... another thing you can do is actually not encapsulate
        // ... the Name to a class, but have all the Name fiels (first, middle, last)
        // ... in the Human class itself
    }
}

class Human {
    private Name name;
    private int age;

    public Human(Name name, int age) {
        name = name;
        this.age = age;
    }

    public String getFirstName(){
        return this.name.getFirstName();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
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
}
