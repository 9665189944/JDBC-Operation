package LibarariOperation;

import java.sql.*;
import java.util.Scanner;

public class FetchSpecificDetail {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter BookID ");
        int Id=sc.nextInt();

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from book where BookID="+Id;


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt=con.createStatement();
                rs = stmt.executeQuery(query);

                if(rs.next()) {
                System.out.println("BookId\tBookName\tPrice");
                System.out.println("===========================================");
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                System.out.println(id + "\t\t" + name + "\t\t" + price);
                }
                else {
                System.out.println("Invalid BookId");
            }

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
            if(rs!=null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
