package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();

    public Post(String title){
        this.title = title;
    }


    public List<PostComment> getComments() {
        return comments;
    }
}