package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc.creatingConnections;

import java.sql.Connection;
import java.sql.SQLException;

public class TestManageDBResources {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			//conn = DriverManager.getConnection(dbUrl, username, password);
			conn = DBUtil.getConnection(DBType.ORADB);
			
			System.out.println("Connection Established to database");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally{
			conn.close();
		}
	}
}
