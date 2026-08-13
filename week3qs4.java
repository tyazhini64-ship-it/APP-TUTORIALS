import java.util.Scanner;

public class week3qs4 {
    static class Car {
        String model;
        int price;

        Car() {
            this.model = "Not Specified";
            this.price = 0;
        }

        Car(String model) {
            this.model = model;
            this.price = 0;
        }

        Car(String model, int price) {
            this.model = model;
            this.price = price;
        }

        void display() {
            System.out.println("Model: " + model + ", Price: " + price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car c1 = new Car();

        System.out.print("Enter Car 2 Model Name: ");
        String model2 = sc.nextLine();
        Car c2 = new Car(model2);

        System.out.print("Enter Car 3 Model Name: ");
        String model3 = sc.nextLine();
        System.out.print("Enter Car 3 Price: ");
        int price3 = sc.nextInt();
        Car c3 = new Car(model3, price3);

        System.out.println("\n--- Showroom Registration Records ---");
        System.out.print("Car 1: ");
        c1.display();
        System.out.print("Car 2: ");
        c2.display();
        System.out.print("Car 3: ");
        c3.display();
    }
}