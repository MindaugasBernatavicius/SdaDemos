package cf.mindaugas.sdademos.http.model;

import java.util.List;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    // For HETEOAS
    private List<String> links;

    public User(int id, String fn, String ln, String email) {
        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    // For HETEOAS
    public void setLinks(List<String> links) {
        this.links = links;
    }
}