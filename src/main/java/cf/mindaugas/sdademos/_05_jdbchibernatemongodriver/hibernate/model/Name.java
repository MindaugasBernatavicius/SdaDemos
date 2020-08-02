package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
    private String first;
    private String middle;
    private String last;

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Name() {
    }

    // getters and setters omitted
}
