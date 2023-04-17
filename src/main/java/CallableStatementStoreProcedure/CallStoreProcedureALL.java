package CallableStatementStoreProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallStoreProcedureALL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Insert Data ");
        System.out.println("Enter the BookId");
        int id= sc.nextInt();
        System.out.println("Enter the BookName");
        String name=sc.next();
        System.out.println("Enter the BookPrice");
        double price=sc.nextDouble();



        System.out.println("Delete the record");
        System.out.println("Enter the BookId");
        int deleteid= sc.nextInt();

        System.out.println("Update value Of Book ");
        System.out.println("Enter the BookPrice1");
        double price1=sc.nextDouble();
        System.out.println("Enter the BookId");
        int updateid= sc.nextInt();



        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            cstmt=con.prepareCall("{call addBook(?,?,?,?,?,?)}");
            cstmt.setInt(1,id);
            cstmt.setString(2,name);
            cstmt.setDouble(3,price);
            cstmt.setInt(4,deleteid);
            cstmt.setDouble(5,price1);
            cstmt.setInt(6,updateid);
            cstmt.execute();


            System.out.println("Procedure executed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
