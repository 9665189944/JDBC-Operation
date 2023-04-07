package LibarariOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertBookUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book Id ");
        int Id=sc.nextInt();
        System.out.println("Enter Book Name ");
        String Name=sc.next();
        System.out.println("Enter Book Price ");
        double Price=sc.nextDouble();


        Connection con=null;
        Statement stmt=null;
        String query="insert into book values("+Id+",'"+Name+"',"+Price+")";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"Insert Book record successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      finally {
            if(con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
