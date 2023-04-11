package PreparedStatement;

import java.sql.*;

public class DeleteRecordSametime {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        String query="delete from employee_info where emp_Id=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,1);
            int count1= pstmt.executeUpdate();
            pstmt.setInt(1,2);
            int count2= pstmt.executeUpdate();
            System.out.println(count1+count2+"record are delete");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
