package cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.assoc;

import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.manytomany.Author;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.manytomany.Book;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.manytomany.Employee;
import cf.mindaugas.sdademos.jdbchibernatemongodriver.hibernate.model.manytomany.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class ManyToMany {

    public static void runExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create two authors and persist the book. Take note, this is an inverted relationship between book and author.
        // ... so if we persist only the author, the book will not be persisted. In this case we need to persist the book

        Author author1 = new Author("Jack", "Kerouac");
        Author author2 = new Author("Mindaugas", "Bernatavicius");
        Set<Author> authors = new HashSet();
        authors.add(author1);
        authors.add(author2);

        Book book1 = new Book("On the Road ");
        Book book2 = new Book("Lonesome Traveler");
        Set<Book> books = new HashSet();
        books.add(book1);
        books.add(book2);

        book1.setAuthors(authors);
        session.persist(book1);

        transaction.commit();
        session.close();
    }

    public static void runExampleBaeldung() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String[] employeeData = { "Peter Oven", "Allan Norman" };
        String[] projectData = { "IT Project", "Networking Project" };
        Set<Project> projects = new HashSet<>();

        for (String proj : projectData) {
            projects.add(new Project(proj));
        }

        for (String emp : employeeData) {
            Employee employee = new Employee(emp.split(" ")[0], emp.split(" ")[1]);

            employee.setProjects(projects);
            session.persist(employee);
        }

        transaction.commit();
        session.close();
    }

}
