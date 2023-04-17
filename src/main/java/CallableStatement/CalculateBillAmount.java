package CallableStatement;

import java.sql.*;
import java.util.Scanner;
//Create store function in SQLyog and Write JDBC Program Call Function using CallableStatement.
public class CalculateBillAmount {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Qty");
        int qty= sc.nextInt();
        System.out.println("Enter the Amount");
        double Amount=sc.nextDouble();

        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{?=call CalculateBillAmount(?,?)}");
            cstmt.setInt(2,qty);
            cstmt.setDouble(3,Amount);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Total Bill Amount is With Discount ="+cstmt.getDouble(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
