package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.jdbc.blobandclob;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImageFromDB {

    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        int id = 33;

        String sql = "SELECT photo FROM Employee WHERE Id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Blob imgBlob = rs.getBlob("photo");

            FileOutputStream fos = new FileOutputStream("C:\\Users\\bernam\\Desktop\\img.jpg");

            fos.write(imgBlob.getBytes(1, (int) imgBlob.length()));

            fos.flush();
            fos.close();

            System.out.println("Photo of Employee " + id + " has been Downloaded successfully");
        } else {
            System.out.println("Employee Record Not Found.");
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}
