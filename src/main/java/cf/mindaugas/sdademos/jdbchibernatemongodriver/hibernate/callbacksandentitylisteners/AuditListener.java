package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.callbacksandentitylisteners;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.Movie;

import javax.persistence.PrePersist;

public class AuditListener {

    @PrePersist
    // javax.persistence.PersistenceException: Callback methods annotated in a listener bean class must return void and take one argument
    // External callback methods (in a listener class) should always return void and take one argument that specifies the entity which is the source of the lifecycle event
    public void prepersist(Movie movie){
        System.out.println("prepersist called from AuditListener");
    }
}
