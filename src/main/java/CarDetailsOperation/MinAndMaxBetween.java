package CarDetailsOperation;

import java.sql.*;
import java.util.Scanner;

public class MinAndMaxBetween {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Min Price");
        double Price1 = sc.nextDouble();
        System.out.println("Max Price");
        double Price2 = sc.nextDouble();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from car_info where Price Between " + Price1 + " and " + Price2 + " ";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("ID\tmodel\tCompany\tCatagory\tPrice");
            System.out.println("===========================================");
            while (rs.next()) {
                int ID = rs.getInt(1);
                String model = rs.getString(2);
                String Company = rs.getString(3);
                String Catagory = rs.getString(4);
                //double Price = rs.getDouble(5);

                System.out.println(ID + "\t" + model + "\t" + Company + "\t" + Catagory + "\t");
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
            if (rs != null)
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








