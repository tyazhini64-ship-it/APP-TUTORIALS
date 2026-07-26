import java.util.Scanner;

public class week1qs4a {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------SWAP ROLL NUMBERS (WITH TEMP)-------------");
        int roll1, roll2, temp;

        System.out.print("Enter Student 1's Roll Number: ");
        roll1=sc.nextInt();

        System.out.print("Enter Student 2's Roll Number: ");
        roll2=sc.nextInt();

        System.out.println("Before swapping: Roll 1 = " + roll1 + ", Roll 2 = " + roll2);

        temp=roll1;
        roll1=roll2;
        roll2=temp;

        System.out.println("After swapping: Roll 1 = " + roll1 + ", Roll 2 = " + roll2);

        System.out.println("-------------------------------------------------------");
    }
}