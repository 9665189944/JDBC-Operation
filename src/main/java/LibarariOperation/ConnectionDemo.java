package LibarariOperation;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost/","root","Akhil@01999");
            System.out.println("Connection Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
