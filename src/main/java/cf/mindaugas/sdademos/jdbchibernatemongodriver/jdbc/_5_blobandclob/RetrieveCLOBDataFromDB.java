package cf.mindaugas.sdademos.jdbchibernatemongodriver.jdbc._5_blobandclob;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class RetrieveCLOBDataFromDB {

	public static void main(String[] args) throws SQLException, IOException{
		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);


		// Task: refactor this to use a prepared statement
		String sql = "SELECT cv FROM Employee where Id = 4";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			Clob resume = rs.getClob("cv");
			Reader data = resume.getCharacterStream();
			
			int i;
			String resumeDetails = "";
			while((i = data.read()) != -1){
				resumeDetails += ((char) i);
			}
			System.out.println("Resume Details for Employee 4");

			// Task: fix this to leave newlines in place
            // ... a good example to anwser the question
            // where will we ever need hex and encodings?
			System.out.println(resumeDetails);
		} else{
			System.err.println("No Record Found For Employee With The ID 4.");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
