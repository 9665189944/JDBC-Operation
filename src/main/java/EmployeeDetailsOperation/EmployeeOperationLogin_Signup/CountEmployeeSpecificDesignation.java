package EmployeeDetailsOperation.EmployeeOperationLogin_Signup;

import java.sql.*;
import java.util.Scanner;

public class CountEmployeeSpecificDesignation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Desg");
        String desg= sc.next();

        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="Select Count(emp_Id)from employee_info where emp_Desiganation=?";


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,desg);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println( "Total =" + count);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
