package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc.storedprocedures;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

// TODO ::
// 1. Improve design - Error :PROCEDURE world.AddNewEmployee does not exist is thrown after the user has already entered data
// 2. Add better error handling

public class TestCallableBatchProcessing {

    // 	use jdbcdemo;
    //
    // 	CREATE TABLE Employee (
    // 			id INT NOT NULL,
    // 			emplName varchar(255),
    // 	emplEmail varchar(255),
    // 	hireDate DATE,
    // 	salary INT,
    // 	cv MEDIUMTEXT,
    // 	photo BLOB
    // )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;
    // 	DROP TABLE Employee;
    //
    // 	INSERT INTO Employee() VALUES (33, 'Mindaugas', 'darbas.mindaugas@gmail.com', '2018-01-10', 455, null, null);
    // 	SELECT * FROM Employee;
    //
    // 	DELIMITER //
    // 	CREATE PROCEDURE AddNewEmployee (
    // 		IN id INT,
    // 		IN emplName VARCHAR(255),
    // 		IN emplEmail VARCHAR(255),
    // 		IN hireDate DATE,
    // 		IN salary INT)
    // 	BEGIN
    // 	INSERT INTO Employee() VALUES (id, emplName, emplEmail, hireDate, salary, null, null);
    // 	END //
    // 	DELIMITER ;
    // 	drop procedure AddNewEmployee;

    public static void main(String[] args) {
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
                CallableStatement callableStatement = conn.prepareCall("call AddNewEmployee(?,?,?,?,?)");
        ) {
            String option;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Employee Number: ");
                int empno = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Employee Name: ");
                String ename = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Hiredate: ");
                Date dob = Date.valueOf(scanner.nextLine());
                System.out.print("Enter Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());

                callableStatement.setInt(1, empno);
                callableStatement.setString(2, ename);
                callableStatement.setString(3, email);
                callableStatement.setDate(4, dob);
                callableStatement.setDouble(5, salary);

                callableStatement.addBatch();

                System.out.print("Do You Want To Add Another Record (yes /no): ");
                option = scanner.nextLine();
            } while (option.equals("yes"));

            int[] updateCounts = callableStatement.executeBatch();
            System.out.println("Total Records Inserted are : " + updateCounts.length);

        } catch (SQLException ex) {
            DBUtil.showErrorMessage(ex);
        }
    }
}
