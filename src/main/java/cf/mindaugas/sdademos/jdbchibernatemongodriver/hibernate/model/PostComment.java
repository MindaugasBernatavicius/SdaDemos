package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model;

import javax.persistence.*;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String review;

    public PostComment(String review){
        this.review = review;
    }
}