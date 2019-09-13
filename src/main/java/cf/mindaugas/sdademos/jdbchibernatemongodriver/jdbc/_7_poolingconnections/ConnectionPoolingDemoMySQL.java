package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc._7_poolingconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Ref: // Ref: https://www.baeldung.com/java-connection-pooling

// SHOW STATUS WHERE `variable_name` = 'Threads_connected';
// SHOW status like '%onn%';
//
// SELECT IFNULL(usr,'All Users') user,IFNULL(hst,'All Hosts') host,COUNT(1) Connections
// FROM(
//     SELECT user usr,LEFT(host,LOCATE(':',host) - 1) hst
//     FROM information_schema.processlist
//     WHERE user NOT IN ('system user','root')
// ) A GROUP BY usr,hst WITH ROLLUP;

public class ConnectionPoolingDemoMySQL {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ConnectionPool connectionPool = BasicConnectionPool
                .create("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");

        System.out.println("----- Check connection count now -----");
        Thread.sleep(15000);

        // no other connections are created, they are taken from the poll
        Connection conn1 = connectionPool.getConnection();
        Connection conn2 = connectionPool.getConnection();
        Connection conn3 = connectionPool.getConnection();

        System.out.println("----- Check connection count now -----");
        Thread.sleep(15000);

        connectionPool.releaseConnection(conn1);
        connectionPool.releaseConnection(conn2);
        connectionPool.releaseConnection(conn3);
    }
}

interface ConnectionPool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    List<Connection> getConnectionPool();
    int getSize();
    String getUrl();
    String getUser();
    String getPassword();
    void shutdown() throws SQLException;;
}

class BasicConnectionPool implements ConnectionPool {

    private final String url;
    private final String user;
    private final String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 10;
    private final int MAX_POOL_SIZE = 20;

    public static BasicConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new BasicConnectionPool(url, user, password, pool);
    }

    private BasicConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public List<Connection> getConnectionPool() {
        return connectionPool;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void shutdown() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }
}