package LibarariOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBook {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Deleted BookID ");
        int BookID= sc.nextInt();

        Connection con=null;
        Statement stmt=null;

        String query="Delete from Book Where BookId="+BookID;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" Book record delete  successfully");
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
