package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.hql;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.User;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.hql.Phone;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.hql.PhoneType;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.hql.UserWPhoneObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sun.awt.windows.ThemeReader;

import javax.persistence.Query;
import java.util.List;

public class HQL {

    // TASKS:
    // 0. Write a simple query, check that the size of the result set is appropriate. DB populated with hibernate
    // 1. Populate the table directly w/o going through hibernate - see if everything is retrieved
    // X. Named queries - usage
    // 2. Select clause - students should figure out how to create this example
    // 3. Where clause
    // 4. Order By clause
    // 5. Group By clause
    // 6. Named parameters
    // 7. Update clause
    // 8. Delete clause
    // 9. Insert clause
    // 10. Aggregate methods
    // 11. Pagination

    public static void runExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        // Transaction transaction = session.beginTransaction();

        // Select all users
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.getResultList();
        // System.out.println(users.size());
        for (User user : users){
            System.out.println("Id: " + user.getId() + ", name: " + user.getName());
        }


        // Select only names from Users for all users
        hql = "SELECT U.name FROM User U";
        query = session.createQuery(hql);
        List<String> names = query.getResultList();
        // System.out.println(names.size());
        for (String name : names){
            System.out.println("Name is: " + name);
        }

        System.out.println("--------------- Named queries -----------------");
        query = session.createQuery(
            "select u from User u where name = :name"
        );

        query.setParameter("name", "Robert");
        List<User> usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }

        query = session.getNamedQuery("get_user_by_name");
        query.setParameter("name", "Robert");
        usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }

        query = session.getNamedQuery("get_user_by_name_fuzzy");
        query.setParameter("name", "M%");
        usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }

        // transaction.commit();
        session.close();
    }


    public static void runExampleJoins(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("--------------- Joins: inserting data -----------------");

        UserWPhoneObject userWPhoneObject1 = new UserWPhoneObject("Mindaugas w/ Phone Obect", "Brazilka");
        Phone cellPhone1 =  new Phone("+370 625 22259", PhoneType.MOBILE);
        Phone officePhone1 =  new Phone("+37 251 999225", PhoneType.LAND_LINE);
        userWPhoneObject1.getPhones().add(cellPhone1);
        userWPhoneObject1.getPhones().add(officePhone1);
        session.persist(userWPhoneObject1);

        UserWPhoneObject userWPhoneObject2 = new UserWPhoneObject("Jim", "Carrey");
        Phone cellPhone2 =  new Phone("+111 625 22259", PhoneType.MOBILE);
        Phone officePhone2 =  new Phone("+22 251 999225", PhoneType.LAND_LINE);
        userWPhoneObject2.getPhones().add(cellPhone2);
        userWPhoneObject2.getPhones().add(officePhone2);
        session.persist(userWPhoneObject2);

        transaction.commit();

        int secondsToSleep = 2;
        System.out.println("--------------- Joins: done inserting, check the database, sleeping for " +  secondsToSleep + " seconds -----------------");
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<UserWPhoneObject> userWPhoneObjectList = session.createQuery(
            "select distinct pwpo " +
                    "from UserWPhoneObject pwpo " +
                    "inner join pwpo.phones ph " +
                    "where ph.type = :phoneType", UserWPhoneObject.class)
            .setParameter("phoneType", PhoneType.MOBILE)
            .getResultList();

        for (UserWPhoneObject u : userWPhoneObjectList){
            System.out.print("Name is: " + u.getName() + " ... and the phones are: ");
            for(Phone p : u.getPhones()){
                System.out.print(p.getValue() + " ");
            }
            System.out.println();
        }


        session.close();
    }
}
