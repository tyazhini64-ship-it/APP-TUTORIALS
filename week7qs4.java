import java.util.ArrayList;
import java.util.Scanner;

class BankTask implements Runnable {
    private String activity;
    private int delay;

    public BankTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " | Activity: " + activity + " | Execution Count: " + i);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
        }
    }
}

public class week7qs4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Thread> threads = new ArrayList<>();

        System.out.print("Enter delay for Transaction Processing thread (ms): ");
        int d1 = scanner.nextInt();
        System.out.print("Enter delay for Balance Updating thread (ms): ");
        int d2 = scanner.nextInt();
        System.out.print("Enter delay for SMS Notification thread (ms): ");
        int d3 = scanner.nextInt();
        scanner.close();

        Thread t1 = new Thread(new BankTask("Transaction Processing", d1));
        t1.setName("TransactionThread");

        Thread t2 = new Thread(new BankTask("Balance Updating", d2));
        t2.setName("BalanceThread");

        Thread t3 = new Thread(new BankTask("SMS Notification", d3));
        t3.setName("SMSThread");

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All banking operations completed successfully.");
    }
}