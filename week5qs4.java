import java.util.ArrayList;
import java.util.Scanner;

abstract class Product {
    protected int productId;
    protected String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("ID: " + productId + " | Product: " + name + " | Original: $" + price + " | Final: $" + getFinalPrice());
    }
}

class Electronics extends Product {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }
}

class Books extends Product {
    public Books(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
}

public class week5qs4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> cart = new ArrayList<>();

        System.out.print("Enter number of products in cart: ");
        int totalProducts = sc.nextInt();

        for (int i = 0; i < totalProducts; i++) {
            System.out.println("\nSelect Category for Product " + (i + 1) + ":");
            System.out.println("1. Electronics (10% OFF)\n2. Clothing (20% OFF)\n3. Books (5% OFF)");
            int category = sc.nextInt();

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Product Name: ");
            String name = sc.next();
            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();

            if (category == 1) {
                cart.add(new Electronics(id, name, price));
            } else if (category == 2) {
                cart.add(new Clothing(id, name, price));
            } else if (category == 3) {
                cart.add(new Books(id, name, price));
            } else {
                System.out.println("Invalid category. Item skipped.");
            }
        }

        System.out.println("\n--- Final Cart Summary ---");
        for (Product product : cart) {
            product.displayDetails();
        }

        sc.close();
    }
}