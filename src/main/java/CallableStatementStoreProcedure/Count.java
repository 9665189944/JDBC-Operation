package CallableStatementStoreProcedure;

import java.sql.*;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Company Name");
        String name=sc.next();

        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{call caroperations(?,?)}");
            cstmt.setString(1,name);
             cstmt.registerOutParameter(2, Types.INTEGER);
             cstmt.execute();
            System.out.println("Total No of Model are "+cstmt.getInt(2));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
