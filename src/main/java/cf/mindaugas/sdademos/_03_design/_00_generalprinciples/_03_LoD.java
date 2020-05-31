package cf.mindaugas.sdademos._03_design._00_generalprinciples;

public class _03_LoD {
    public static void main(String[] args) {
        Human h1 = new Human(
                new Name("Mindaugas", "Jonas", "Bernatavičius"), 30);

        // non compliant o.d().x().z() --> method chaining
        System.out.println(h1.getName().getFirstName());

        // ... instead do this ... however this introduces tight coupling and duplication
        // ... what if you had to add all the getters for all the fields
        System.out.println(h1.getFirstName());

        // ... another thing you can do is actually not encapsulate
        // ... the Name to a class, but have all the Name fiels (first, middle, last)
        // ... in the Human class itself


        // When would I use this principle - only when I have multiple calls to "non-friend" methods
        // String s1 = h1.getName().getFirstName();
        // String s2 = h1.getName().getMiddleName();
        // String s3 = h1.getName().getLastName();
        // System.out.println(s1 + s2 + s3);

        // ... instead of this, let's delegate this logic to human.printFullName();
    }
}

class Human {
    private Name name;
    private int age;

    public Human(Name name, int age) {
        this.name = name;
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

    // public void printFullName(){
    //     String s1 = name.getFirstName();
    //     String s2 = name.getMiddleName();
    //     String s3 = name.getLastName();
    //     System.out.println(s1 + s2 + s3);
    // }
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
