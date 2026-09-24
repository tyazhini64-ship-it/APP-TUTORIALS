package hospitalDetails.doctor;

public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private double totalFeeCollected;

    public Doctor(String doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.totalFeeCollected = 0.0;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addFee() {
        totalFeeCollected += consultationFee;
    }

    public double getTotalFeeCollected() {
        return totalFeeCollected;
    }

    public void display() {
        System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization + ", Fee: " + consultationFee);
    }
}