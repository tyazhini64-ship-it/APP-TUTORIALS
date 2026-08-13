import java.util.Scanner;

public class week3qs5 {
    static class Geometry {
        // Area of Square
        int area(int side) {
            return side * side;
        }

        // Area of Rectangle
        double area(double length, double breadth) {
            return length * breadth;
        }

        // Area of Circle
        double area(double radius) {
            return 3.14 * radius * radius;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Geometry g = new Geometry();

        System.out.print("Enter side of square: ");
        int side = sc.nextInt();

        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();

        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();

        System.out.println("\n--- Calculated Areas ---");
        System.out.println("Area of Square: " + g.area(side));
        System.out.println("Area of Rectangle: " + g.area(length, breadth));
        System.out.println("Area of Circle: " + g.area(radius));
    }
}