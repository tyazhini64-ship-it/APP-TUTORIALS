import java.util.Scanner;

public class week1qs2 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------SUPERMARKET CALCULATIONS-------------");
        double price1, price2, total, difference, product, quotient, remainder;

        System.out.print("Enter Price of First Product: ");
        price1=sc.nextDouble();

        System.out.print("Enter Price of Second Product: ");
        price2=sc.nextDouble();

        total=price1+price2;
        difference=price1-price2;
        product=price1*price2;
        quotient=price1/price2;
        remainder=price1%price2;

        System.out.println("Total (Sum): " + total+ " Rs.");
        System.out.println("Difference: " + difference+ " Rs.");
        System.out.println("Product: " + product+ " Rs.");
        System.out.println("Quotient: " + quotient+ " Rs.");
        System.out.println("Remainder: " + remainder+ " Rs.");

        System.out.println("--------------------------------------------------");
    }
}