package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc.blobandclob;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCLOBDataToEmpResume {


    // System.out.println("Working Directory = " + System.getProperty("user.dir"));

    //     use jdbcdemo;
    //
    //     CREATE TABLE Employee (
    //             id INT NOT NULL,
    //             emplName varchar(255),
    //     emplEmail varchar(255),
    //     hireDate DATE,
    //     salary INT,
    //     cv MEDIUMTEXT,
    //     photo BLOB
    // )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;
    //     DROP TABLE Employee;
    //
    //     INSERT INTO Employee() VALUES (33, 'Mindaugas', 'darbas.mindaugas@gmail.com', '2018-01-10', 455, null, null);
    //     SELECT * FROM Employee;
    //
    //     DELIMITER //
    //     CREATE PROCEDURE AddNewEmployee (
    //             IN id INT,
    //             IN emplName VARCHAR(255),
    //     IN emplEmail VARCHAR(255),
    //     IN hireDate DATE,
    //     IN salary INT)
    //     BEGIN
    //     INSERT INTO Employee() VALUES (id, emplName, emplEmail, hireDate, salary, null, null);
    //     END //
    //             DELIMITER ;
    //     drop procedure AddNewEmployee;

	public static void main(String[] args) throws SQLException, IOException {

		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
		PreparedStatement pstmt = null;
		
		String sql = "Update Employee set cv = ? where id = 4";
		pstmt = conn.prepareStatement(sql);
		
		String resumeFile = ".\\target\\classes\\cv.txt";

		File file = new File(resumeFile);
		FileReader reader = new FileReader(file);

		pstmt.setCharacterStream(1, reader, (int)file.length());
	
		int rslt = pstmt.executeUpdate();

		// Remember .executeUpdate() returns an integer representing how many rows were updated
        // if you know there should always be at least one row that is being updated - inspect return val!
		if(rslt > 0)
            System.out.println("Resume Updated Successfully...");
        else
            System.out.println("Nothing was updated");

		pstmt.close();
		conn.close();
	}
}
