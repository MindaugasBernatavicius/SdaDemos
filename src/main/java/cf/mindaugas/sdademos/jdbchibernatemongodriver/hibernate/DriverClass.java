package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.CreateEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.hql.HQL;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.types.valuetypes.ValueTypes;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.xmlbasedconfig.XmlBasedConfig;

import java.net.MalformedURLException;

public class DriverClass {
    public static void main(String[] args) throws MalformedURLException {

        // 0. - Creating simple entity: hello world level example for Hibernate
        // CreateEntity.runExample();

        // 1. - Lets improve the example by returning the Id of created object
        // System.out.println(CreateEntity.runExampleReturningId());

        // 2. - Other CRUD operations read and update
        // ReadAndUpdateEntity.runExampleWEmbedables();

        // 2. - Read and delete
        // ReadAndDeleteEntity.runExampleWEmbedables();

        // . - Basic Types
        // Covered above w/ Create entity

        // . - Value types - embedables
        // ValueTypes.runExampleWEmbedables();

        // . collections
        // ValueTypes.runExampleWCollections();

        // . - Entity types cf\mindaugas\sdademos

        // . - Interceptors / callbacks
        // HibernateOperations hibernateOperations = new HibernateOperations();
        // // hibernateOperations.saveMovie();
        // long id = hibernateOperations.saveMovieGiveId();
        //
        // Movie movie = hibernateOperations.getMovie(id);
        //
        // System.out.println(movie.getAge());

        // . - assoc
        // Assoc.runExampleWEmbedables();

        // . - xml based config
        XmlBasedConfig.runExample();

        // . - HQL
        // HQL.runExample();

    }
}
