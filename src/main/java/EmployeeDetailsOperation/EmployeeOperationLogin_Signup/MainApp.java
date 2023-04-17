package EmployeeDetailsOperation.EmployeeOperationLogin_Signup;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       EmployeeManager E1=new EmployeeManager();

        System.out.println("1.LOGIN");
        System.out.println("2.SIGNUP");
        int choice=sc.nextInt();
        if(choice==1)
        {
            System.out.println("Enter UserName");
            String user=sc.next();
            System.out.println("Enter Password");
            String password=sc.next();
            boolean status=E1.login(user,password);
            if(status==true)
            {
                System.out.println("Select Mode of Operation");
                System.out.println("1.Add Employee");

                System.out.println("2.View Employee");
                int type= sc.nextInt();
                if(type==1)
                {
                    System.out.println("Enter Employee Name");
                    String name= sc.next();
                    System.out.println("Enter Employee Desg");
                    String desg= sc.next();
                    System.out.println("Enter Employee Salary");
                     double salary= sc.nextDouble();
                     E1.addEmployee(name,desg,salary);

                }else if(type==2)
                {
                    E1.viewEmplyeeDetails();
                }else {
                    System.out.println("Invalid Operation");
                }
            }else
            {
                System.out.println("Invalid Login Credentials");
            }
        } else if (choice==2) {
            System.out.println("Enter userName");
            String name= sc.next();
            System.out.println("Enter Password");
            String password=sc.next();
            E1.signUp(name,password);

        }else {
            System.out.println("Invalid choice");
        }
    }
}
