package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class UserCloneable implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;
    private int age;

    public UserCloneable() {
    }

    public UserCloneable(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCloneable clone() throws CloneNotSupportedException {
        UserCloneable userCloneableClone = (UserCloneable) super.clone();
        userCloneableClone.id = null;
        userCloneableClone.name = this.name;
        userCloneableClone.surname = this.surname;
        return userCloneableClone;
    }

}
