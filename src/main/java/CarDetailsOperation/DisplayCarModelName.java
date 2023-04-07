package CarDetailsOperation;

import java.sql.*;
import java.util.Scanner;

public class DisplayCarModelName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Catagory Name");
        String Catagory = sc.next();
        System.out.println("Company Name");
        String Company = sc.next();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select Model from car_info where Company='" + Company + "' and Catagory='" + Catagory + "'";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("Model");
            System.out.println("===========================================");
            while (rs.next()) {
                String Model = rs.getString(1);
                System.out.println(Model);
            }
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
