import java.util.Scanner;

public class week2qs7 {
    static class Marks {
        int m1, m2, m3;

        Marks(int m1, int m2, int m3) {
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        }

        void calculateAndDisplay() {
            int total = m1 + m2 + m3;
            double avg = total / 3.0;

            System.out.println("Subject 1: " + m1);
            System.out.println("Subject 2: " + m2);
            System.out.println("Subject 3: " + m3);
            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + avg);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Marks for Subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter Marks for Subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter Marks for Subject 3: ");
        int m3 = sc.nextInt();

        Marks m = new Marks(m1, m2, m3);
        System.out.println();
        m.calculateAndDisplay();
    }
}