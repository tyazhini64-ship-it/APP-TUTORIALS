import java.util.Scanner;

public class week2qs6 {
    static class Employee {
        int id;
        String name;
        String designation;
        double salary;

        Employee(int id, String name, String designation, double salary) {
            this.id = id;
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }

        void displayDetails() {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
            System.out.println("Salary: ₹" + salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Employee 1 Details ---");
        System.out.print("Enter ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Designation: ");
        String desig1 = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal1 = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        System.out.println("\n--- Employee 2 Details ---");
        System.out.print("Enter ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Designation: ");
        String desig2 = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal2 = sc.nextDouble();

        Employee e1 = new Employee(id1, name1, desig1, sal1);
        Employee e2 = new Employee(id2, name2, desig2, sal2);

        System.out.println("\n--- Employee Records ---");
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
    }
}