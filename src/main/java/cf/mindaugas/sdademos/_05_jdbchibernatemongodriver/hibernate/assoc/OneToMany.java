package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.assoc;

import cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.onetomany.BookOneToMany;
import cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.onetomany.UserOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToMany {

    public static void runExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserOneToMany userOneToMany = new UserOneToMany("Mindaugas", "mindaugas@yahoo.com");

        session.persist(userOneToMany);
        session.persist(new BookOneToMany("Java 4 dummies", userOneToMany));
        session.persist(new BookOneToMany("Java Generics", userOneToMany));

        transaction.commit();
        session.close();
    }
}
