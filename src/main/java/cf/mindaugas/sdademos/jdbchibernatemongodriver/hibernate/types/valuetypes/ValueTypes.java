package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.types.valuetypes;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.Contact;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.Name;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.UserWPhone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;

public class ValueTypes {

    public static void runExampleWEmbedables() throws MalformedURLException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        Contact contact = new Contact(2, new Name("Mindaugas", "", "Bernatavičius"), "Notes 1", new URL("http://www.abc.com"), true);
        session.persist(contact);
        transaction.commit();
        session.close();
    }

    public static void runExampleWCollections() throws MalformedURLException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<String> phones = new ArrayList<>();
        phones.add("+77 889 008033");
        phones.add("+370 84 08977777");

        // CREATE
        UserWPhone userWPhone = new UserWPhone("Alexardr", "Bell");
        userWPhone.setPhones(phones);
        session.persist(userWPhone);

        transaction.commit();
        session.close();
    }
}
