import java.util.*;

interface PaymentMethod {
    void makePayment(double amount);
}

class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public void makePayment(double amount) {
        System.out.println("Processing UPI Payment of $" + amount + " using UPI ID: " + upiId);
    }
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void makePayment(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount + " using Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class NetBankingPayment implements PaymentMethod {
    private String bankName;

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    public void makePayment(double amount) {
        System.out.println("Processing Net Banking Payment of $" + amount + " via " + bankName);
    }
}

public class week5qs3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<PaymentMethod> methods = new ArrayList<>();

        methods.add(new UPIPayment("user@okaxis"));
        methods.add(new CreditCardPayment("1234567890123456"));
        methods.add(new NetBankingPayment("HDFC Bank"));

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI\n2. Credit Card\n3. Net Banking");
        int choice = sc.nextInt();
        double amount = 250.75;

        if (choice >= 1 && choice <= methods.size()) {
            PaymentMethod selectedMethod = methods.get(choice - 1);
            selectedMethod.makePayment(amount);
        } else {
            System.out.println("Invalid Selection");
        }
        sc.close();
    }
}