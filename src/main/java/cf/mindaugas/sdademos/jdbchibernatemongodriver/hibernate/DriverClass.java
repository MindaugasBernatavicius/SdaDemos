package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.CreateEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.ReadAndDeleteEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.crud.ReadAndUpdateEntity;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DriverClass {
    public static void main(String[] args) {

        // 0. - Creating simple entity: hello world level example for Hibernate
        // CreateEntity.runExample();

        // 1. - Lets improve the example by returning the Id of created object
        System.out.println(CreateEntity.runExampleReturningId());

        // 2. - Other CRUD operations read and update
        // ReadAndUpdateEntity.runExample();

        // 2. - Read and delete
        // ReadAndDeleteEntity.runExample();

        // 3.

    }
}
