package EmployeeDetailsOperation.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;

        String query="insert into employee_info  values(?,?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            pstmt =con.prepareStatement(query);
            //1st record
            pstmt.setInt(1,0);
            pstmt.setString(2,"Amit");
            pstmt.setString(3,"HR");
            pstmt.setDouble(4,200000.0);
            int count1=pstmt.executeUpdate();
            //
            //2nd record
            pstmt.setInt(1,0);
            pstmt.setString(2,"Ajit");
            pstmt.setString(3,"admin");
            pstmt.setDouble(4,400000.0);
            int count2=pstmt.executeUpdate();

            //3rd record
            pstmt.setInt(1,0);
            pstmt.setString(2,"Anuj");
            pstmt.setString(3,"VP");
            pstmt.setDouble(4,500000.0);
            int count3=pstmt.executeUpdate();
            System.out.println(count1+count2+count3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
