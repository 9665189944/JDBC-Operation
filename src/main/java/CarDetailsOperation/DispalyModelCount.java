package CarDetailsOperation;

import java.sql.*;

public class DispalyModelCount {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        // int count = 0;
        String query = "select Company,Count(Model) from Car_info group by Company";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("Company\tModel count");
            System.out.println("===========================================");
            while (rs.next()) {
                String model= rs.getString(1);
                int count = rs.getInt(2);

                System.out.println(model + "\t" + count);
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