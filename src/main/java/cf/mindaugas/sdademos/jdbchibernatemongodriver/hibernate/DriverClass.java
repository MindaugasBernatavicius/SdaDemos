package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.assoc.ManyToMany;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.assoc.OneToMany;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.assoc.OneToOne;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.callbacksandentitylisteners.HibernateOperations;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.CreateEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.ReadAndDeleteEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.ReadAndUpdateEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.hql.HQL;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.Movie;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.types.valuetypes.ValueTypes;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.xmlbasedconfig.XmlBasedConfig;

import java.net.MalformedURLException;

public class DriverClass {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        // 0. - Creating simple entity: hello world level example for Hibernate
        // CreateEntity.runExample();

        // 1. - Lets improve the example by returning the Id of created object
        // System.out.println(CreateEntity.runExampleReturningId());

        // 2. - Other CRUD operations read and update
        // ReadAndUpdateEntity.runExample();

        // 3. - Read and delete
        // ReadAndDeleteEntity.runExample();

        // 4. - Basic Types
        // Covered above w/ Create entity.

        // 5. - Value types - embedables
        // ValueTypes.runExampleWEmbedables();

        // 6. - Collections
        // ValueTypes.runExampleWCollectionsArrayLists();
        // ValueTypes.runExampleWCollectionsHashMaps(); // --> TODO

        // 7. - Entity types
        // Covered above w/ Create entity.

        // 8. - Interceptors / callbacks
        // HibernateOperations hibernateOperations = new HibernateOperations();
        // // hibernateOperations.saveMovie();
        // long id = hibernateOperations.saveMovieGiveId();
        // Movie movie = hibernateOperations.getMovie(id);
        // System.out.println(movie.getAge());

        // 9. - Associations
        // System.out.println(OneToOne.runExamplePersist()); // use create strategy
        // OneToOne.runExampleQueryAndUpdate(1); // use update strategy

        // OneToMany.runExamplePersist();
        // ManyToMany.runExamplePersist();
        // ManyToMany.runExampleBaeldung();

        // 10. - xml based config
        // XmlBasedConfig.runExample();

        // 11. - HQL
        // HQL.runExample(); // includes named queries
        HQL.runExampleJoins();
    }
}
