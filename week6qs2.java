import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " successfully using Credit Card.");
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " successfully using UPI.");
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " successfully using Net Banking.");
    }
}

public class week6qs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();

        System.out.println("Choose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        int choice = sc.nextInt();

        Payment p = null;
        if (choice == 1) {
            p = new CreditCardPayment();
        } else if (choice == 2) {
            p = new UPIPayment();
        } else if (choice == 3) {
            p = new NetBankingPayment();
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        p.pay(amount);
        sc.close();
    }
}