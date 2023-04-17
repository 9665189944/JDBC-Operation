package CallableStatement;

import java.sql.*;
import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Radius");
        double rad= sc.nextDouble();


        Connection con=null;
        CallableStatement cstmt=null;


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{?=call areaOfCircle(?)}");
            cstmt.setDouble(2,rad);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Area of circle="+cstmt.getDouble(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
