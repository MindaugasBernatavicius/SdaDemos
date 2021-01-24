package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<BookOneToMany> books;

    public UserOneToMany() {
    }

    public UserOneToMany(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setBooks(List<BookOneToMany> books) {
        this.books = books;
    }
}
