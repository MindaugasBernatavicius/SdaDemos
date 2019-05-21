package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

// CREATE TABLE `user` (
//     `id` bigint(20) NOT NULL AUTO_INCREMENT,
//     `birthdate` date DEFAULT NULL,
//     `height` int(11) NOT NULL,
//     `name` varchar(255) DEFAULT NULL,
//     `surname` varchar(255) DEFAULT NULL,
//     PRIMARY KEY (`id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.AUTO)      // no support in MySQL
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)  // no support in MySQL
    // @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;
    private int age;

    public User() {}

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public long getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
}