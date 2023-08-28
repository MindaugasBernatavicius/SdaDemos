package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.crud;

import cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CreateEntity {
    public static void runExample() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("----- Transaction has begun ----------");

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);

        // How can we check whether the entity is persisted
        // during the persist() call or during the commit()?

        // System.out.println("----- Check now -----");
        // Thread.sleep(15000);

        transaction.commit();

        // System.out.println("----- Check now -----");
        // Thread.sleep(15000);

        session.close();

        System.out.println("----- Will wait a bit, then close sessionFactory ----------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sessionFactory.close();
    }

    public static long runExampleReturningId() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);
        transaction.commit();
        session.close();

        return user.getId();
    }
}
