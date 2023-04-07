package CarDetailsOperation;

import java.sql.*;

public class DisplayCatagory {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select catagory from Car_info";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            rs= stmt.executeQuery(query);
            System.out.println("Catagory");
            System.out.println("===========================================");
            while (rs.next()) {
                String Catagory = rs.getString(1);
                System.out.println(Catagory);
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
