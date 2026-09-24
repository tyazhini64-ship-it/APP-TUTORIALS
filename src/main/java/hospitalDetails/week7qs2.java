package hospitalDetails;


import hospitalDetails.doctor.Doctor;
import hospitalDetails.patient.Patient;
import java.util.ArrayList;
import java.util.Scanner;

public class week7qs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of doctors: ");
        int dCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < dCount; i++) {
            System.out.println("Enter details for doctor " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Specialization: ");
            String spec = scanner.nextLine();
            System.out.print("Fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();
            doctors.add(new Doctor(id, name, spec, fee));
        }

        System.out.print("Enter number of patients: ");
        int pCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < pCount; i++) {
            System.out.println("Enter details for patient " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Disease/Specialization: ");
            String disease = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            patients.add(new Patient(id, name, disease, age));
        }

        System.out.println("\n--- Patient & Doctor Assignments ---");
        for (Patient p : patients) {
            Doctor assignedDoctor = null;
            for (Doctor d : doctors) {
                if (d.getSpecialization().equalsIgnoreCase(p.getDisease())) {
                    assignedDoctor = d;
                    d.addFee();
                    break;
                }
            }

            p.display();
            if (assignedDoctor != null) {
                System.out.print(" -> Treated by: ");
                assignedDoctor.display();
            } else {
                System.out.println(" -> No matching doctor specialization found.");
            }
        }

        System.out.println("\n--- Total Fees Collected ---");
        for (Doctor d : doctors) {
            d.display();
            System.out.println("Total Collection: " + d.getTotalFeeCollected());
        }
        scanner.close();
    }
}