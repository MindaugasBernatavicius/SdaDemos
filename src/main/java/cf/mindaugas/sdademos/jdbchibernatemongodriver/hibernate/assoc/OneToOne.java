package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.assoc;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.onetoone.AddressOneToOne;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.onetoone.UserOneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOne {

    public static long runExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AddressOneToOne addressOneToOne = new AddressOneToOne("Lithuania", "Kaunas", "Taikos pr.");
        UserOneToOne userOneToOne = new UserOneToOne("Mindaugas", "mindaugas@gmail.com", addressOneToOne);

        // session.persist(addressOneToOne); // if you are not using:
        session.persist(userOneToOne);

        transaction.commit();
        session.close();

        return userOneToOne.getId();
    }

    public static void runExampleQueryAndUpdate(long id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserOneToOne userOneToOne = session.find(UserOneToOne.class, id);
        userOneToOne.setAddress(new AddressOneToOne("Germany", "Berlin", "BurgerShtraze"));
        transaction.commit();
        session.close();
    }
}
