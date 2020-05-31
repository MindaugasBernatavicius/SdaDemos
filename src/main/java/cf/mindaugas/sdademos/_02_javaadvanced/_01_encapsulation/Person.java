package cf.mindaugas.sdademos._02_javaadvanced._01_encapsulation;

public class Person {
    private String firstName;
    private boolean male;
    private FullName fullName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}

class FullName {
    String firstName;
    String middleName;
    String lastName;
}
