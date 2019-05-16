package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ReadAndDeleteEntity {

    public static void runExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = transaction = session.beginTransaction();

        // DELETE
        User user = session.find(User.class, 2L);
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
