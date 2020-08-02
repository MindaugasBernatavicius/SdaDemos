package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc.poolingconnections;


import oracle.jdbc.pool.OracleConnectionCache;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolingDemo {

	public static void main(String[] args) throws SQLException, InterruptedException {

        // Oracle
        // CREATE TABLE Employees (
        //     Employee_ID number primary key,
        //     First_Name varchar2(255) default NULL,
        //     Last_Name varchar2(255) default NULL,
        //     Salary varchar2(50) default NULL
        // );


        // You will need to download a UCP library: https://docs.oracle.com/en/database/oracle/oracle-database/19/jjuar/index.html
        // PoolDataSource  pds = PoolDataSourceFactory.getPoolDataSource();
        // also see: https://docs.oracle.com/en/database/oracle/oracle-database/19/development.html
        // https://www.oracle.com/technetwork/vasiliev-oracle-jdbc-090470.html

        // https://docs.oracle.com/cd/A91202_01/901_doc/java.901/a90211/connpoca.htm
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();


		ds.setDriverType("thin");
		ds.setServerName("192.168.56.14");
		ds.setPortNumber(1521);
		ds.setServiceName("XE");
		ds.setUser("SYSTEM");
		ds.setPassword("root");


        System.out.println("Cache props:" + ds.getConnectionCacheProperties());


        // MySQL: https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2/2.6.0
        // CREATE TABLE Employees (
        //     Employee_ID int primary key,
        //     First_Name varchar(255) default NULL,
        //     Last_Name varchar(255) default NULL,
        //     Salary varchar(50) default NULL
        // );
        //
        // INSERT into Employees() values (1, "Mindaugas", "Bernatavičius", 1500);
        // System.out.println("Active: " + ds.getNumActive() + "; idle: " + ds.getNumIdle());


        // System.out.println("----- Check connection count now -----");
        // Thread.sleep(10000);

        PooledConnection pconn = ds.getPooledConnection();

        Statement stmt = null;
        ResultSet rs = null;

		for(int i = 0; i < 5; i++) {

            Connection conn = pconn.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("Select * From Employees");

            String format = "%-15s%-20s%-15s\n";
            System.out.println("Iteration :" + i);
            System.out.format(format, "First_Name", "Last_Name", "Salary");
            System.out.format(format, "-------------", "-----------------", "-------------");

            while (rs.next()) {
                System.out.format(format,
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getString("Salary")
                );
            }

            Thread.sleep(1000);
        }

        // System.out.println("----- Check connection count now -----");
        // Thread.sleep(10000);

        if(rs != null)
            rs.close();
        stmt.close();
		// conn.close();
		pconn.close();
	}


}
