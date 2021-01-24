package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.crud;

import cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ReadAndUpdateEntity {

    public static void runExample() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // UPDATE
        User user = session.find(User.class, 1L); // NullPointerException if object is not found
        user.setName("Robert C.");
        transaction.commit();
        session.close();
    }
}
