package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

// create table Contact (
//         id integer not null,
//         first varchar(255),
//         last varchar(255),
//         middle varchar(255),
//         notes varchar(255),
//         starred boolean not null,
//         website varchar(255),
//         primary key (id)
//  )

@Entity(name = "Contact")
public class Contact {
    @Id
    private Integer id;
    private Name name;
    private String notes;
    private URL website;
    @Type(type = "boolean")
    private boolean starred;

    public Contact(Integer id, Name name, String notes, URL website, boolean starred) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.website = website;
        this.starred = starred;
    }

    public Contact() {
    }

    //Getters and setters are omitted for brevity


    // myUser.equals(anotherUser)
    @Override
    public boolean equals(Object o) {
        Contact contact = (Contact) o;
        if (starred != contact.starred) return false;
        return website != null ? website.equals(contact.website) : contact.website == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (starred ? 1 : 0);
        return result;
    }
}

