package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.otherDBs;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.AppUserParent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Oracle {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        System.out.println("--- SessionService and _6_metadata are set! ---");

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();

        System.out.println("--- Session opened! ---");

        Transaction transaction = session.beginTransaction();

        System.out.println("--- Transaction has begun! ---");

        // CREATE
        // AppUser user = new AppUser("Robert", "Martin");
        AppUserParent user = new AppUserParent("Grandpa", "Smithson");
        session.persist(user);

        System.out.println("--- Transaction about to commit! ---");
        transaction.commit();
        session.close();

        System.out.println("--- Session close! ---");
    }
}
