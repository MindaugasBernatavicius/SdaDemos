package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc._08_DealingWithJavaPojosWithJDBC;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
class Customer {
    private Long id;
    private String name;
}

class CustomerDAO {
    private static Connection getConnection() throws SQLException {
        var connStr = "jdbc:mysql://localhost:3306/joinsexample?profileSQL=true";
        return DriverManager.getConnection(connStr, "root", "root");
    }

    public static List<Customer> getAll() throws SQLException {
        var conn = getConnection();
        var customers = new ArrayList<Customer>();
        var stmt = conn.prepareStatement("SELECT * FROM customer");
        var rslt = stmt.executeQuery();
        while(rslt.next())
            customers.add(new Customer(
                    rslt.getLong(1),
                    rslt.getString(2))
            );
        conn.close();
        return customers;
    }

    public static void save(Customer customer) throws SQLException {
        var conn = getConnection();
        var SQL = "INSERT INTO customer VALUES (?, ?)";
        var stmt = conn.prepareStatement(SQL);
        stmt.setLong(1, customer.getId());
        stmt.setString(2, customer.getName());
        var recordsCreated = stmt.executeUpdate();
        System.out.println("Records created: " + recordsCreated);
        conn.close();
    }

    // EXERCISE: provide methods like get(Long id), delete(Long id), delete(Customer customer), update(?)
}

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Before inserting a new customer");
            System.out.println(CustomerDAO.getAll());
            CustomerDAO.save(new Customer(10L, "Xavier"));
            System.out.println("\n\nAfter inserting a new customer");
            System.out.println(CustomerDAO.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
