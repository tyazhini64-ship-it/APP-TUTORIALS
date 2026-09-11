import java.util.Scanner;

interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuth();
    void faceRecognitionAuth();
}

class BankingApplication implements AdvancedSecurity {
    public void login() {
        System.out.println("Basic login successful.");
    }
    public void logout() {
        System.out.println("Logged out successfully.");
    }
    public void fingerprintAuth() {
        System.out.println("Fingerprint authentication verified.");
    }
    public void faceRecognitionAuth() {
        System.out.println("Face recognition authentication verified.");
    }
}

public class week6qs3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingApplication app = new BankingApplication();

        System.out.print("Do you want to login? (yes/no): ");
        String loginChoice = sc.next();

        if (loginChoice.equalsIgnoreCase("yes")) {
            app.login();
            System.out.print("Choose authentication method (1. Fingerprint, 2. Face Recognition): ");
            int authChoice = sc.nextInt();
            if (authChoice == 1) {
                app.fingerprintAuth();
            } else if (authChoice == 2) {
                app.faceRecognitionAuth();
            }
            System.out.print("Do you want to logout? (yes/no): ");
            String logoutChoice = sc.next();
            if (logoutChoice.equalsIgnoreCase("yes")) {
                app.logout();
            }
        }
        sc.close();
    }
}