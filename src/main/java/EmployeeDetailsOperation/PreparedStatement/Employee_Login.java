package EmployeeDetailsOperation.PreparedStatement;

import sun.security.util.Password;

import java.sql.*;
import java.util.Scanner;

public class Employee_Login {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the UserName");
        String Name=sc.next();
        System.out.println("Enter the Password");
        String password=sc.next();


        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;


        String query="Select * from Employee_login";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            pstmt= con.prepareStatement(query);
            rs=pstmt.executeQuery();

               boolean status=false;

      while (rs.next()) {
          String name=rs.getString("userName");
          String Upassword=rs.getString("userPassword");
          if (Name.equals(name) && Upassword.equals(password)) {
              System.out.println("Login Successfully");
              status=true;
          }

      }
      if(status==false) {
                System.out.println("Invalid Login Details");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
