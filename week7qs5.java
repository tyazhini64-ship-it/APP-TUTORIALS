import java.util.ArrayList;
import java.util.Scanner;

class TrafficJunction extends Thread {
    private int interval;

    public TrafficJunction(String name, int interval) {
        setName(name);
        this.interval = interval;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println("Thread Name: " + getName() + " | Traffic Status: Normal Flow (Iteration " + i + ")");
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class week7qs5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TrafficJunction> junctions = new ArrayList<>();

        System.out.print("Enter monitoring interval for Junction 1 (ms): ");
        int i1 = scanner.nextInt();
        System.out.print("Enter monitoring interval for Junction 2 (ms): ");
        int i2 = scanner.nextInt();
        System.out.print("Enter monitoring interval for Junction 3 (ms): ");
        int i3 = scanner.nextInt();
        scanner.close();

        junctions.add(new TrafficJunction("Junction-North", i1));
        junctions.add(new TrafficJunction("Junction-South", i2));
        junctions.add(new TrafficJunction("Junction-East", i3));

        for (TrafficJunction j : junctions) {
            j.start();
        }

        for (TrafficJunction j : junctions) {
            try {
                j.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Traffic monitoring completed for all junctions.");
    }
}