package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc._1_creatingConnectionsExceptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExceptionHandling {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection(DBType.ORADB);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// rs = stmt.executeQuery("select * from user_tables");
			rs = stmt.executeQuery("select * from non_existant_table");
			rs.last();
			System.out.println("Total number of Rows :" + rs.getRow());
		} catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		} finally{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
