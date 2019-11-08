package cf.mindaugas.sdademos.javaadvanced._01_encapsulation;

public class Person {
    private String firstName;
    private boolean male;

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