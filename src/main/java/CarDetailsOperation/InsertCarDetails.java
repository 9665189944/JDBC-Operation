package CarDetailsOperation;

import java.sql.*;
import java.util.Scanner;

public class InsertCarDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Model Name");
        String model = sc.next();
        System.out.println("Enter the Company Name");
        String Company = sc.next();
        System.out.println("Enter the Category Name");
        String category = sc.next();
        System.out.println("Enter the Price ");
        double Price = sc.nextDouble();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "insert into Car_info(Model,Company,Catagory,price)values('" + model + "','" + Company + "','" + category + "'," + Price + ")";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count + " Car data Inserted successfully");
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

