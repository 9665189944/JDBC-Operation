package EmployeeDetailsOperation.EmployeeMaxAndMin;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LogicClass l1=new LogicClass();
        System.out.println("select Mode of");
        System.out.println("1.Max Salary");
        System.out.println("2.Min Salary");
        int choice= sc.nextInt();

        if(choice==1)
        {
            l1.Maxsalary();
        }else if(choice==2)
        {
            l1.MinSalary();
        }
    }
}
