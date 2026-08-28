import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
    public abstract String getShapeName();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getShapeName() {
        return "Circle";
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public String getShapeName() {
        return "Rectangle";
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getShapeName() {
        return "Triangle";
    }
}

public class week5qs5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter total number of shapes to construct: ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("\nSelect Shape Type for Shape " + (i + 1) + ":");
            System.out.println("1. Circle\n2. Rectangle\n3. Triangle");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Radius: ");
                double r = sc.nextDouble();
                shapeList.add(new Circle(r));
            } else if (choice == 2) {
                System.out.print("Enter Length: ");
                double l = sc.nextDouble();
                System.out.print("Enter Width: ");
                double w = sc.nextDouble();
                shapeList.add(new Rectangle(l, w));
            } else if (choice == 3) {
                System.out.print("Enter Base: ");
                double b = sc.nextDouble();
                System.out.print("Enter Height: ");
                double h = sc.nextDouble();
                shapeList.add(new Triangle(b, h));
            } else {
                System.out.println("Invalid Choice. Skipping shape.");
            }
        }

        System.out.println("\n--- Areas of Entered Shapes ---");
        for (Shape s : shapeList) {
            System.out.printf("%s Area: %.2f\n", s.getShapeName(), s.calculateArea());
        }

        sc.close();
    }
}