// package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc._1_creatingConnectionsExceptions;
//
// import java.sql.*;
//
// public class _01_TestOracleConnection {
//
//     static final String dbUrlOracle = "jdbc:oracle:thin:@192.168.56.14:1521:xe";
//     static final String username = "SYSTEM";
//     static final String password = "root";
//
//     public static void main(String[] args) throws SQLException {
//
//         // https://mikesmithers.wordpress.com/2019/01/03/installing-and-configuring-oracle-18cxe-on-centos/
//         Connection conn = DriverManager.getConnection(dbUrlOracle, username, password);
//
//         // START DATABASE SERVER
//         // su - oracle
//         // . oraenv
//         // XE
//         // /opt/oracle/product/18c/dbhomeXE/bin/lsnrctl start
//         // /opt/oracle/product/18c/dbhomeXE/bin/dbstart /opt/oracle/product/18c/dbhomeXE
//         // sqlplus '/ as sysdba'
//         // SQL> startup
//
//         // STOP DATABASE SERVER
//         // $ lsnrctl stop
//         // $ dbshut
//         // If above failed login as sysdba user:
//         // $ sqlplus '/ as sysdba'
//         // SQL> shutdown
//
//         // PreparedStatement stmt = conn.prepareStatement("SELECT 'Hello World!' FROM dual");
//         // PreparedStatement stmt = conn.prepareStatement("SELECT instance_name, version, status FROM v$instance");
//         // PreparedStatement stmt = conn.prepareStatement("select ora_database_name from dual");
//         PreparedStatement stmt = conn.prepareStatement("SELECT table_name FROM user_tables");
//         // PreparedStatement stmt = conn.prepareStatement("SELECT owner, table_name FROM all_tables");
//         ResultSet rslt = stmt.executeQuery();
//
//         while (rslt.next()) {
//             System.out.println(rslt.getString(1) + " | ");
//             // System.out.println(rslt.getString(2));
//             // System.out.println(rslt.getString(3));
//             // System.out.println(rslt.getString(4)); // java.sql.SQLException: Invalid column index
//         }
//
//         System.out.println("Connection to Oracle Database Established Successfully.");
//     }
// }
