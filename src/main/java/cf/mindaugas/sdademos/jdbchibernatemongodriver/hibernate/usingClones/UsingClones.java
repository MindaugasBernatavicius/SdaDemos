package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.usingClones;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.User;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.UserCloneable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UsingClones {
    public static void main(String[] args) throws CloneNotSupportedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        UserCloneable userCloneable = new UserCloneable("Robert", "Martin");
        session.persist(userCloneable);

        UserCloneable userCloneable2 = userCloneable.clone();
        System.out.println(userCloneable2.getName());
        session.persist((UserCloneable)userCloneable2);

        transaction.commit();
        session.close();
    }
}
