package CourseOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCourseDetails {
    public static void main(String[] args) throws FileNotFoundException {
        Connection con=null;
        PreparedStatement pstmt=null;
        FileInputStream fin=null;

        String query="insert into course_info values(?,?,?)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,"WT");
            fin=new FileInputStream("E:\\J2EE\\j2EEProgram\\Program\\OIP.jpg");
            pstmt.setBinaryStream(3,fin);
            int count= pstmt.executeUpdate();
            System.out.println(count+" Record Inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
