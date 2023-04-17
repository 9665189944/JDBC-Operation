package EmployeeDetailsOperation.EmployeeMaxAndMin;

import java.sql.*;

public class LogicClass {
    static Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    void Maxsalary() {

        String query = "select * from employee_info where emp_salary =(select Max(emp_salary) from employee_info)";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int  Id =rs.getInt(1);
                String Name =rs.getString(2);
                String Deg  =rs.getString(3);
                double salary  =rs.getDouble(4);
                System.out.println("Max salary Details");
                System.out.println("===================================");
                System.out.println(Id+"\t"+Name+"\t"+Deg+"\t"+salary);
                System.out.println("====================================");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        void MinSalary ()
        {

            String query1 = "select * from employee_info where emp_salary =(select Min(emp_salary) from employee_info)";

            try {
                pstmt = con.prepareStatement(query1);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                  int  Id =rs.getInt(1);
                   String Name =rs.getString(2);
                  String Deg  =rs.getString(3);
                  double salary  =rs.getDouble(4);
                    System.out.println("Min salary Details");
                    System.out.println("===================================");
                    System.out.println(Id+"\t"+Name+"\t"+Deg+"\t"+salary);
                    System.out.println("====================================");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

}
