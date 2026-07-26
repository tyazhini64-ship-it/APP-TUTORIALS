import java.util.Scanner;

public class week1qs3 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------AREA OF RECTANGLE-------------");
        double length,breadth,area;
        System.out.print("Enter Length of the rectangle: ");
        length=sc.nextDouble();

        System.out.print("Enter Breadth of the rectangle: ");
        breadth=sc.nextDouble();

        area=length*breadth;

        System.out.println("The area of the rectangle is "+ area +" m^2");

        System.out.println("-------------------------------------------");



    }
    
}
