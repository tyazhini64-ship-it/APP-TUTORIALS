import java.util.Scanner;

public class week3qs3 {
    static class Employee {
        int id;
        String name;
        int salary;

        Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        void display() {
            System.out.println("Employee ID : " + id);
            System.out.println("Employee Name : " + name);
            System.out.println("Salary : " + salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear scanner buffer

        System.out.print("Employee Name : ");
        String name = sc.nextLine();

        System.out.print("Salary : ");
        int salary = sc.nextInt();

        Employee e = new Employee(id, name, salary);
        System.out.println("\n--- Employee Details ---");
        e.display();
    }
}