package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc._6_metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String oraUser="SYSTEM";
	private static final String oraPwd ="root";
	private static final String mySqlUser = "root";
	private static final String mySqlPwd = "root";
	private static final String oraCS = "jdbc:oracle:thin:@192.168.56.14:1521:xe";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/jdbcdemo";

	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
		case ORADB:
			return DriverManager.getConnection(oraCS, oraUser, oraPwd);
		case MYSQLDB:
			return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
		default:
			return null;
		}
	}

	public static void showErrorMessage(SQLException e){
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.getErrorCode());
	}
}
