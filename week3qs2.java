import java.util.Scanner;

public class week3qs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] attendance = new int[7];
        int count = 0;

        System.out.println("Enter attendance for 7 days (1 for Present, 0 for Absent):");
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            attendance[i] = sc.nextInt();
            if (attendance[i] == 1) {
                count++;
            }
        }

        double percentage = (count / 7.0) * 100;

        System.out.println("\nTotal Present Days: " + count);
        System.out.println("Attendance Percentage: " + percentage + "%");

        if (percentage >= 75.0) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
    }
}