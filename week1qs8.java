import java.util.Scanner;

public class week1qs8 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------TOTAL SALARY CALCULATOR-------------");
        double basicSalary, allowance, total;

        System.out.print("Enter basic salary: ");
        basicSalary=sc.nextDouble();

        System.out.print("Enter allowance: ");
        allowance=sc.nextDouble();

        total=basicSalary+allowance;

        System.out.println("The total salary of the employee is " + total + " Rs.");

        System.out.println("-------------------------------------------------");
    }
}