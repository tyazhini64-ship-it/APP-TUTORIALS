import java.util.Scanner;

class Vehicle {
    String vehicleNumber, brand;
    double speed;

    Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand + ", Number: " + vehicleNumber + ", Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    void displayDetails() {
        System.out.println("[Car] Brand: " + brand + ", Doors: " + numberOfDoors + ", Speed: " + speed + " km/h");
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    void displayDetails() {
        System.out.println("[Bike] Brand: " + brand + ", Has Gear: " + hasGear + ", Speed: " + speed + " km/h");
    }
}

public class week6qs1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Car Number: ");
        String cNum = sc.next();
        System.out.print("Enter Car Brand: ");
        String cBrand = sc.next();
        System.out.print("Enter Car Speed: ");
        double cSpeed = sc.nextDouble();
        System.out.print("Enter Car Doors: ");
        int cDoors = sc.nextInt();
        Vehicle v1 = new Car(cNum, cBrand, cSpeed, cDoors);

        System.out.print("Enter Bike Number: ");
        String bNum = sc.next();
        System.out.print("Enter Bike Brand: ");
        String bBrand = sc.next();
        System.out.print("Enter Bike Speed: ");
        double bSpeed = sc.nextDouble();
        System.out.print("Enter Bike Has Gear (true/false): ");
        boolean bGear = sc.nextBoolean();
        Vehicle v2 = new Bike(bNum, bBrand, bSpeed, bGear);

        v1.displayDetails();
        v2.displayDetails();
        sc.close();
    }
}