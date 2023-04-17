package EmployeeDetailsOperation.EmployeeOperationLogin_Signup;

import java.sql.*;

public class EmployeeManager {
    static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean login(String user, String password) {


        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean status = false;

        String query = "Select * from Employee_login";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("userName");
                String Upassword = rs.getString("userPassword");
                if (user.equals(name) && password.equals(Upassword)) {
                    System.out.println("Login Successfully");
                    status = true;
                }

            }
            if (status == false) {
                System.out.println("Invalid Login Details");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        finaly();
        return status;
    }

    public void addEmployee(String name, String desg, double salary) {
        PreparedStatement pstmt = null;

        String query = "insert into employee_info(emp_Name,emp_Desiganation,emp_salary)  values(?,?,?)";

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, desg);
            pstmt.setDouble(3, salary);
            int row = pstmt.executeUpdate();
            System.out.println(row + "Record insert Successfully");
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
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        finaly();
    }

    public void viewEmplyeeDetails() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from employee_info";

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            System.out.println("Id+\"\\t\"+Name+\"\\t\"+Deg+\"\\t\"+salary");
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Name = rs.getString(2);
                String Deg = rs.getString(3);
                double salary = rs.getDouble(4);
                System.out.println("===================================");
                System.out.println(Id + "\t" + Name + "\t" + Deg + "\t" + salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
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
        finaly();
    }

    public void signUp(String name, String password) {

        Connection con = null;
        PreparedStatement pstmt = null;

        String query = "insert into employee_Login(userName,userPassword)  values(?,?)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Akhil@01999");
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, password);

            int count1 = pstmt.executeUpdate();
            System.out.println(count1 + " Register Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
          finaly();
    }

    void finaly() {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
