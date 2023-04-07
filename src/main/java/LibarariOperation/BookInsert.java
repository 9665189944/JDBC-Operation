package LibarariOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookInsert {
    public static void main(String[] args) {

        Connection con=null;
        Statement stmt=null;


        String query="insert into Book values(1,'j2ee',3000.0)";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" Book Inserted successfully");
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
