package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc._2_crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetDemo {

//	MYSQL
// 	DROP TABLE IF EXISTS Department;
// 	CREATE TABLE `Department` (
// 			`Department_Id` bigint(20) NOT NULL,
//     `Department_Name` varchar(255) NOT NULL,
//     `Manager_Id` bigint(20) NOT NULL,
//     `Location_Id` bigint(20) DEFAULT NULL,
// 	PRIMARY KEY (`Department_Id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;
//
//
// 	Select Department_Id, Department_Name, Manager_Id, Location_Id from Department;
//
// 	INSERT INTO jdbcdemo.department (Department_Id, Department_Name, Manager_Id, Location_Id) VALUES (1, 'Dep1', 1, 1);
// 	INSERT INTO jdbcdemo.department (Department_Id, Department_Name, Manager_Id, Location_Id) VALUES (2, 'Dep2', 1, 1);
// 	INSERT INTO jdbcdemo.department (Department_Id, Department_Name, Manager_Id, Location_Id) VALUES (3, 'Dep3', 9, 1);

	public static void main(String[] args) throws SQLException{

		try(
            Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
            // CONCUR_UPDATABLE: The ResultSet object can be updated using the ResultSet interface. The default ResultSet concurrency is CONCUR_READ_ONLY.
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("Select Department_Id, Department_Name, Manager_Id, Location_Id from Department");
		){
			// UPDATE
			rs.absolute(3);
			rs.updateString("Department_Name", "Information Technology");
			rs.updateRow();
			System.out.println("Record Updated Successfully");

			// INSERT NEW
			rs.moveToInsertRow();
			rs.updateInt("Department_Id", 999);
			rs.updateString("Department_Name", "Training");
			rs.updateInt("Manager_Id", 200);
			rs.updateInt("Location_Id", 1800);
			rs.insertRow();
			System.out.println("Record Inserted Successfully");
		} catch(SQLException ex){
			DBUtil.showErrorMessage(ex);
		}
	}
}