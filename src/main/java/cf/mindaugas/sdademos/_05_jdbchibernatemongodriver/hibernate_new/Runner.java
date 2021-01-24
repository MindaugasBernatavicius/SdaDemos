package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate_new;

import org.hibernate.Session;

public class Runner {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ex0_persistAnEntity();
    }

    public static void ex0_persistAnEntity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(new Customer(0, "Mindaugas"));
        session.flush();
    }
}