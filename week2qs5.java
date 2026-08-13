import java.util.Scanner;

public class week2qs5 {
    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Student 1 ---");
        System.out.print("Enter Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Age: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.println("\n--- Student 2 ---");
        System.out.print("Enter Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Age: ");
        int age2 = sc.nextInt();

        Student s1 = new Student(name1, age1);
        Student s2 = new Student(name2, age2);

        System.out.println("\n--- Registered Student Details ---");
        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
    }
}