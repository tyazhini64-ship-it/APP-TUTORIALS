import java.util.Scanner;

public class week3qs1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = new int[5];
        int total = 0;

        System.out.println("Enter prices for 5 products:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Product " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
            total = total + prices[i];
        }

        System.out.println("\nTotal Bill : " + total);

        if (total > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }
    }
}