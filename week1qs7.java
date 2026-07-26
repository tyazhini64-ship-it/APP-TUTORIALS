import java.util.Scanner;

public class week1qs7 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------PASS/FAIL-------------");
        double marks;

        System.out.print("Enter student's marks: ");
        marks=sc.nextDouble();

        if(marks >= 50){
            System.out.println("Result: Pass");
        }else{
            System.out.println("Result: Fail");
        }

        System.out.println("-----------------------------------------------------");
    }
}