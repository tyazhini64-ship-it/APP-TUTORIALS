import java.util.Scanner;

interface OnlineTransaction {}

interface Payment {
    void pay(double amount);
}

interface SecurePayment extends Payment {
    boolean verifyPayment();
}

class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account No: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String accNo, double bal) { super(accNo, bal); }
    @Override void displayDetails() {
        System.out.println("[Savings Account] No: " + accountNumber + ", Balance: $" + balance);
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accNo, double bal) { super(accNo, bal); }
    @Override void displayDetails() {
        System.out.println("[Current Account] No: " + accountNumber + ", Balance: $" + balance);
    }
}

class UPIPayment implements SecurePayment, OnlineTransaction {
    public boolean verifyPayment() {
        System.out.println("Verifying UPI PIN...");
        return true;
    }
    public void pay(double amount) {
        if (verifyPayment()) {
            System.out.println("Successfully paid $" + amount + " via UPI.");
        }
    }
}

class CardPayment implements Payment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Successfully paid $" + amount + " via Credit/Debit Card.");
    }
}

public class week6qs6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Savings Account Number: ");
        String sAcc = sc.next();
        System.out.print("Enter Savings Balance: ");
        double sBal = sc.nextDouble();
        Account acc1 = new SavingsAccount(sAcc, sBal);

        System.out.print("Enter Current Account Number: ");
        String cAcc = sc.next();
        System.out.print("Enter Current Balance: ");
        double cBal = sc.nextDouble();
        Account acc2 = new CurrentAccount(cAcc, cBal);

        acc1.displayDetails();
        acc2.displayDetails();

        System.out.println("-------------------");
        System.out.print("Enter payment amount: ");
        double amt = sc.nextDouble();
        System.out.print("Choose payment method (1. UPI, 2. Card): ");
        int payChoice = sc.nextInt();

        Payment p;
        if (payChoice == 1) {
            p = new UPIPayment();
        } else {
            p = new CardPayment();
        }
        p.pay(amt);

        if (p instanceof OnlineTransaction) {
            System.out.println("Transaction is tracked as an Online Transaction.");
        }
        sc.close();
    }
}