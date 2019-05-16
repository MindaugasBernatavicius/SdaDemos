package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingWithResultSets {

	public static void main(String[] args) throws SQLException {

        // DROP TABLE Employees;
        //
        // CREATE TABLE Employees (
        //     Employee_ID number primary key,
        //     First_Name varchar2(255) default NULL,
        //     Last_Name varchar2(255) default NULL,
        //     Salary varchar2(50) default NULL
        // );
        //
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (1,'Venus','Hernandez',6029);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (2,'Hiroko','Delgado',9757);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (3,'Jescie','Wooten',2154);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (4,'Barrett','Rice',1567);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (5,'Shellie','Garner',250);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (6,'Sydnee','Leach',4979);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (7,'Chancellor','Russo',7662);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (8,'Kirsten','Stein',6599);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (9,'Harper','Valenzuela',4981);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (10,'Bernard','Douglas',7817);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (11,'Angelica','Fitzpatrick',5379);
        // INSERT INTO Employees (Employee_ID,First_Name,Last_Name,Salary) VALUES (12,'Yvonne','Molina',6971);

        // commit;


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection(DBType.ORADB);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from Employees");

			// String format = "%-4s%-20s%-25s%-10f\n";
			while (rs.next()){
                // System.out.println("|" + rs.getString("Employee_ID")
                //                 + "|" + rs.getString("First_Name")
                //                 + "|" + rs.getString("Last_Name")
                //                 + "|");

                System.out.format("|%3s|%8s|%-10s|\n",
                        rs.getString("Employee_ID"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"));
            }
				// System.out.format(format,
                //     rs.getString("Employee_ID"),
                //     rs.getString("First_Name"),
                //     rs.getString("Last_Name"),
                //     rs.getFloat("Salary"));

		} catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		} finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
	}

}
