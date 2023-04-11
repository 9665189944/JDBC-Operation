package Product;

import java.sql.*;
import java.util.Scanner;

public class ProductOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the CName ");
        String CName = sc.next();
        System.out.println("Enter the CQyt");
        int  CQyt = sc.nextInt();
        System.out.println("Enter the CPrice ");
        double CPrice = sc.nextDouble();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "insert into Cart values('" + CName + "'," +CQyt + "," + CPrice + ")";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count + " Cart data Inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
