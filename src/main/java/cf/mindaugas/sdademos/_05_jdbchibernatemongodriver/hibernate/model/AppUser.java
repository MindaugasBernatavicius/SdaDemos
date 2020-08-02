package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;

    public AppUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
