package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.hql;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.Post;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.PostComment;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HQL {

    public static void runExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        // Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> results = query.getResultList();

        System.out.println("------");
        // System.out.println(results.size());

        for (User user : results){
            System.out.println(user.getId());
        }

        // transaction.commit();
        session.close();
    }
}
