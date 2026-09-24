import java.util.ArrayList;
import java.util.Scanner;

class ExamTask implements Runnable {
    private String activityName;
    private int interval;

    public ExamTask(String activityName, int interval) {
        this.activityName = activityName;
        this.interval = interval;
    }

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " | Activity: " + activityName);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

public class week7qs3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Thread> threadList = new ArrayList<>();

        System.out.print("Enter sleep interval for Timer Thread (ms): ");
        int t1 = scanner.nextInt();
        System.out.print("Enter sleep interval for Auto-Save Thread (ms): ");
        int t2 = scanner.nextInt();
        System.out.print("Enter sleep interval for Network Check Thread (ms): ");
        int t3 = scanner.nextInt();
        scanner.close();

        Thread th1 = new Thread(new ExamTask("Displaying Remaining Time", t1));
        th1.setName("TimerThread");

        Thread th2 = new Thread(new ExamTask("Auto-saving Answers", t2));
        th2.setName("AutoSaveThread");

        Thread th3 = new Thread(new ExamTask("Checking Network Connection", t3));
        th3.setName("NetworkThread");

        threadList.add(th1);
        threadList.add(th2);
        threadList.add(th3);

        for (Thread t : threadList) {
            t.start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exam session threads completed.");
    }
}