package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private long id;
    private String title;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private LibraryUser owner;

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LibraryUser getOwner() {
        return owner;
    }
}
