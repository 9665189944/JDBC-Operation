package CallableStatementStoreProcedure;

import java.sql.*;
import java.util.Scanner;

public class CallStoreProcedure {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BookId");
        int id= sc.nextInt();
        System.out.println("Enter the BookName");
        String name=sc.next();
        System.out.println("Enter the BookPrice");
        double price=sc.nextDouble();

        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{call addBook(?,?,?)}");
            cstmt.setInt(1,id);
            cstmt.setString(2,name);
            cstmt.setDouble(3,price);

            cstmt.execute();
            System.out.println("Procedure executed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
