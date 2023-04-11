package Product;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
    static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean status = true;
        while (status) {
            System.out.println("1.Display All Product");
            System.out.println("2.Add to the cart");
            System.out.println("3.Display Cart items");
            System.out.println("4.Remove from the cart");
            System.out.println("5.Update Qty");
            System.out.println("6.Exit");
            System.out.println("Enter Your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAllProduct();
                    break;
                case 2:
                    System.out.println("Enter Product Name");
                    String Name = sc.next();
                    System.out.println("Enter Qty");
                    int Qty = sc.nextInt();
                    //double Price=sc.nextDouble();
                    addCartProduct(Name, Qty);
                    break;
                case 3:
                    displayCartItem();
                    break;
                case 4:
                    System.out.println("Enter the Cart Name");
                    String name= sc.next();
                    deleteCartRecord(name);
                    break;
                case 5:
                    System.out.println("Enter the Cart Name");
                    String PName= sc.next();
                    System.out.println("Enter the Cart Qty");
                    int qty= sc.nextInt();
                    UpdateCartQtyRecord(PName,qty);
                    break;
                case 6:
                    status=false;
                    break;

            }
        }
    }

    static void displayAllProduct() {
//            Connection con=null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "Select * from Product";

        try {
//                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("PId\tPName\tPQty\tPrice");
            System.out.println("=================================================");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                System.out.println(id + "\t\t" + name + "\t\t" + qty + "\t\t" + price);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static void addCartProduct(String Name, int Qty) {
        Statement stmt = null;
        ResultSet rs = null;
        String query = "Select PName,PQty,PPrice from Product where PName='" + Name + "'";
        try {
//                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
//                System.out.println("\tPName\tPQty\tPrice");
//                System.out.println("=================================================");

                String name = rs.getString(1);
                int qty = rs.getInt(2);
                double price = rs.getDouble(3);

                //System.out.println("\t\t" + name + "\t\t" + qty + "\t\t" + price);
                if(Qty<=qty) {
                    String query1="insert into cart values('"+name+"',"+Qty+","+price+")";
                    stmt.executeUpdate(query1);
                }else {
                    System.out.println("===============================================");
                    System.out.println("Out Of Stock");
                }

            } else {
                System.out.println("================================================");
                System.out.println("Product is not Available");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            if (stmt != null) {
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
    static void displayCartItem() {
//            Connection con=null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "Select * from Cart";

        try {
//                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("Name\t\tQty\t\trice");
            System.out.println("=================================================");
            while (rs.next()) {

                String name = rs.getString(1);
                int qty = rs.getInt(2);
                double price = rs.getDouble(3);
                System.out.println(  name + "\t\t" + qty + "\t\t" + price);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static  void deleteCartRecord(String Name)
    {
        Statement stmt=null;

        String query="Delete from Cart where CName='"+Name+"'" ;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println("========================================");
            System.out.println("Record delete  successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
//            if(con!=null)
//            {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static void UpdateCartQtyRecord(String PName,int qty)
    {
        Statement stmt=null;
        String query="update Cart set  Cqty="+qty+" where CName='"+PName+"'";

        try {
            stmt= con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println("Update Successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


    {
        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}



