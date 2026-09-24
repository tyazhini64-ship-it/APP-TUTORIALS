package hospitalDetails.patient;

public class Patient {
    private String patientId;
    private String name;
    private String disease;
    private int age;

    public Patient(String patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Disease: " + disease + ", Age: " + age);
    }
}