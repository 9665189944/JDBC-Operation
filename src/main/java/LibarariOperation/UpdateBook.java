package LibarariOperation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateBook {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book Id");
        int id= sc.nextInt();


        String query="";


        System.out.println("1.Book name");
        System.out.println("2.Book price");
        int choice=sc.nextInt();


        if(choice==1)
        {
            System.out.println("Please Enter the Name of Book"+id);
            String name=sc.next();
            query="update book set BookName='"+name+"'where BookID="+id;
        }
        if(choice==2)
        {
            System.out.println("Please Enter the new price of Book"+id);
            double price=sc.nextDouble();
            query="update book set BookPrice="+price+"where BookID="+id ;
        }
        Connection con=null;
        Statement stmt=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt= con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println("Update Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(con!=null){
                try{
                    con.close();
                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
                if(stmt!=null){
                    try{
                        stmt.close();
                    }catch(SQLException e){
                        throw new RuntimeException(e);
                    }

                }
            }
        }

    }
}
