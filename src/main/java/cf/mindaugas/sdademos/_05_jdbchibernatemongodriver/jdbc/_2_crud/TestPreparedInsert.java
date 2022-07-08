package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc._2_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedInsert {

// MySQL

// 	DROP TABLE IF EXISTS Employee;
//
// 	CREATE TABLE `Employee` (
// 			`id` bigint(20) NOT NULL,
//     `name` varchar(255) DEFAULT NULL,
//     `email` varchar(255) DEFAULT NULL,
//     `date_hired` date DEFAULT NULL,
// 			`salary` int(11) NOT NULL,
// 	PRIMARY KEY (`id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;
//
// 	SELECT * FROM Employee;

    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        int empno;
        String ename, email;
        Date hiredate;
        double salary;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID :");
        empno = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Employee Name :");
        ename = scanner.nextLine();

        System.out.print("Ente Email : ");
        email = scanner.nextLine();

        System.out.print("Enter Date of Joining : ");
        hiredate = Date.valueOf(scanner.nextLine());

        System.out.print("Enter Salary : ");
        salary = scanner.nextDouble();

        String sql = "insert into Employee values ( ?,?,?,?,?,null,null )";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, empno);
        pstmt.setString(2, ename);
        pstmt.setString(3, email);
        pstmt.setDate(4, hiredate);
        pstmt.setDouble(5, salary);

        int result = pstmt.executeUpdate();

        if (result == 1) {
            System.out.println("Record Inserted Successfully.");
        } else {
            System.err.println("Error while adding the record.");
        }

        scanner.close();
        pstmt.close();
        conn.close();
    }


}