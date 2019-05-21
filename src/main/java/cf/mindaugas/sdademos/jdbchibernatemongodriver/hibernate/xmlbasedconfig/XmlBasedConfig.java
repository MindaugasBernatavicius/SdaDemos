package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.xmlbasedconfig;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.AppUserParent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class XmlBasedConfig {

    public static void runExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AppUserParent user = new AppUserParent("Grandpa", "Smithson");
        session.persist(user);

        transaction.commit();
        session.close();
    }

}


