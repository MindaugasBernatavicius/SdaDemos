package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc._1_creatingConnectionsExceptions;

import java.sql.Connection;
import java.sql.SQLException;

public class TestManageDBResources {

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection conn = null;
        try {
            //conn = DriverManager.getConnection(dbUrl, username, password);
            conn = DBUtil.getConnection(DBType.MYSQLDB);
            System.out.println("Connection Established to database");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            // Before closing the connection, let's see
            // - netstat ouput
            // 		netstat -nt | findstr /C:"1521"
            // 		netstat -nt | findstr /C:"3306"
            // - and database MGMT system connection tracking counters:
            // 		use information_schema;
            // 		select host,count(host) from processlist group by host;
            Thread.sleep(10000);
            conn.close();
        }
    }
}
