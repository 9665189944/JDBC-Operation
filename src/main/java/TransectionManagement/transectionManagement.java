package TransectionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class transectionManagement {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book ID");
        int id=sc.nextInt();

        Connection con=null;
        PreparedStatement pstmt=null;


        String query="delete from book_info where book_id=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            con.setAutoCommit(false);
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            int count= pstmt.executeUpdate();

            System.out.println("Are You Sure?");
            System.out.println("1:Yes\t2:NO");

            int choice= sc.nextInt();
            if(choice==1){
                con.commit();
                System.out.println(count+"Record Deleted");

            }else {
                con.rollback();
                System.out.println("Transaction Cancelled");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
