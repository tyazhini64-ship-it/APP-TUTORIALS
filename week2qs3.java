import java.util.Scanner;

public class week2qs3 {
    static class Student {
        String name;
        int rno;

        Student(String name, int rno) {
            this.name = name;
            this.rno = rno;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rno);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rno = sc.nextInt();

        Student s1 = new Student(name, rno);
        System.out.println();
        s1.display();
    }
}