package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc._3_storedprocedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class TestCallableInOut {

// 	DROP TABLE Courses;
//
// 	CREATE TABLE Courses (
// 			CourseId number default NULL,
// 			fees number default NULL,
// 			coursename varchar2(255)
// );
//
// 	CREATE or REPLACE PROCEDURE GetCourseFeesById
// 			(cid in Courses.CourseId%Type, cfees out Courses.CourseId%Type) is
// 	begin
// 	SELECT fees INTO cfees FROM Courses where CourseId = cid;
// 	end;
// /
//
// 	INSERT INTO Courses (CourseId,fees,coursename) VALUES (1,757,'Purus Duis Elementum Corporation');

	public static void main(String[] args) throws SQLException {
		Connection conn= null;
		CallableStatement callableStatement = null;
		Scanner scanner = null;
		
		try{
			 conn = DBUtil.getConnection(DBType.ORADB);
			 callableStatement = conn.prepareCall("{call GetCourseFeesById(?,?)}");
			 scanner = new Scanner(System.in);

			System.out.print("Enter Course ID :");
			int cid = Integer.parseInt(scanner.nextLine());
			
			callableStatement.setInt(1, cid);
			callableStatement.registerOutParameter(2, Types.DOUBLE);
			
			callableStatement.execute();
			
			double fees = callableStatement.getDouble(2);
			
			System.out.println("Course Fees : " + fees);
			
			System.out.print("Enter Roll Number : ");
			int rno = Integer.parseInt(scanner.nextLine());
			
			System.out.print("Enter Student Name :");
			String sname = scanner.nextLine();
			
			System.out.print("Enter your Percentage : ");
			double percentage = Double.parseDouble(scanner.nextLine());
			
			callableStatement = conn.prepareCall("{ call EnrollStudent(?,?,?,?,?) }");
			
			callableStatement.setInt("rno", rno);
			callableStatement.setString("sname", sname);
			callableStatement.setInt("cid", cid);
			callableStatement.setDouble("cfees", fees);
			callableStatement.setDouble("spercent", percentage);
			
			callableStatement.registerOutParameter("cfees", Types.DOUBLE);
			callableStatement.execute();
			
			fees = callableStatement.getDouble("cfees");
			
			System.out.println(sname + " enrolled for the Course with the ID " + cid + " and Final Fees is " + fees);
			
			
		}
		catch(SQLException ex){
			DBUtil.showErrorMessage(ex);
		}
		finally{
			scanner.close();
			callableStatement.close();
			conn.close();
		}
		
	}

}