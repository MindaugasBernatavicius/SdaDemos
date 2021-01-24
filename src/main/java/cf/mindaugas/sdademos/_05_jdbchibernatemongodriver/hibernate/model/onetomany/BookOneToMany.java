package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.onetomany;

import javax.persistence.*;

@Entity
public class BookOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserOneToMany owner;

    public BookOneToMany(String title, UserOneToMany owner) {
        this.title = title;
        this.owner = owner;
    }


}
