package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.mongodriver.covered;

//POJO
public class CustomerModel {
    private String name, surname;

    public CustomerModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
