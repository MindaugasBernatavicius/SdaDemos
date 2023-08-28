package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.hibernate_new;

public class _04_CriteriaQueries {
    public static void _00_simpleExample(){
        try(
            var hibernateUtil = new HibernateUtilAutoClose();
            var sessionFactory = hibernateUtil.getSessionFactory();
            var session = sessionFactory.openSession();
        ){
            // var transaction = session.beginTransaction();

            var cb = session.getCriteriaBuilder();
            var cr = cb.createQuery(Employee.class);
            var root = cr.from(Employee.class);
            cr.select(root);

            var query = session.createQuery(cr);
            var results = query.getResultList();

            System.out.println(results);

            // transaction.commit();
        } catch (Exception e){
            System.out.println("[ERROR] Exception: " + e);
        }
    }

    public static void _01_expressionCriteriaExample(){
        try(
            var hibernateUtil = new HibernateUtilAutoClose();
            var sessionFactory = hibernateUtil.getSessionFactory();
            var session = sessionFactory.openSession();
        ){
            // var transaction = session.beginTransaction();

            var cb = session.getCriteriaBuilder();
            var cr = cb.createQuery(Employee.class);
            var root = cr.from(Employee.class);
            cr.select(root).where(cb.gt(root.get("salary"), 100));
            // more: https://www.baeldung.com/hibernate-criteria-queries#1-using-expressions

            var query = session.createQuery(cr);
            var results = query.getResultList();

            System.out.println(results);

            // transaction.commit();
        } catch (Exception e){
            System.out.println("[ERROR] Exception: " + e);
        }
    }

    public static void _02_sorting(){
        // TBD
    }

    public static void _03_crudActions(){
        // TBD
    }

    public static void _04_projections(){
        // In the context of Object-Relational Mapping (ORM),
        // ... the term "projection" refers to the process of
        // ... selecting and retrieving specific fields or attributes
        // ... from a database table or entity, rather than fetching the entire set of data.
        // ... In other words, projection involves specifying which columns or properties
        // ... of the underlying data source you want to retrieve,
        // ... often for the purpose of optimizing performance
        // ... and reducing the amount of unnecessary data transferred between the database and the application.

        // TBD:: https://www.baeldung.com/jpa-hibernate-projections
    }

    public static void main(String[] args) {
        // _00_simpleExample();
        _01_expressionCriteriaExample();
        // _02_sorting();
        // _03_crudActions();
        // _04_projections();
    }
}
