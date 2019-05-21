package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Assoc {

    public static void runExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // LibraryUser libraryUser = new LibraryUser();
        // libraryUser.setId(1L);
        // libraryUser.setName("Mindaugas");
        // libraryUser.setBooks(new ArrayList(){{new Book(1L, "50 shades of grey");}});
        // session.persist(libraryUser);
        Post post = new Post("First post");

        post.getComments().add(
                new PostComment("My first review")
        );
        post.getComments().add(
                new PostComment("My second review")
        );
        post.getComments().add(
                new PostComment("My third review")
        );

        session.persist(post);

        transaction.commit();
        session.close();
    }

}
