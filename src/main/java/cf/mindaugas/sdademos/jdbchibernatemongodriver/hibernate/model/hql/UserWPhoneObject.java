package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.hql;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserWPhoneObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;
    private int age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userwphone_id")
    private List<Phone> phones = new ArrayList<>();

    public UserWPhoneObject() {
    }

    public UserWPhoneObject(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}