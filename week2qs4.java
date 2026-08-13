import java.util.Scanner;

public class week2qs4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Length of Floor: ");
        double length = sc.nextDouble();

        System.out.print("Enter Breadth of Floor: ");
        double breadth = sc.nextDouble();

        Rectangle r = new Rectangle(length, breadth);
        System.out.println();
        r.calculateAndDisplayArea();
    }
}

class Rectangle {
    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void calculateAndDisplayArea() {
        double area = length * breadth;
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Floor Area: " + area + " sq units");
    }
}