import java.util.Scanner;

public class week1qs5 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------HIGHEST SCORE FINDER-------------");
        int num1, num2, num3;

        System.out.print("Enter 3 scores:");
        num1=sc.nextInt();
        num2=sc.nextInt();
        num3=sc.nextInt();

        if(num1 >= num2 && num1 >= num3)
            System.out.println("Maximum score is " + num1 + " marks.By student 1.");
    

        else if(num2 >= num1 && num2 >= num3)
            System.out.println("Maximum score is " + num2 + " marks.By student 2.");
        
        
        else
            System.out.println("Maximum score is " + num3 + " marks.By student 3.");

        System.out.println("-----------------------------------------------");
    }
}