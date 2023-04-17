package CallableStatementSotreFunction;

import java.sql.*;
import java.util.Scanner;

public class Petrcentage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Percentage");
        double Per= sc.nextDouble();


        Connection con=null;
        CallableStatement cstmt=null;


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{?=call Percentage(?)}");
            cstmt.setDouble(2,Per);
            cstmt.registerOutParameter( 1, Types.VARCHAR);
            cstmt.execute();
            System.out.println("Result ="+cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
