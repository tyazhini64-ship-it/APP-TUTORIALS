import java.util.ArrayList;

class Employee {
    protected String name;
    protected int empId;
    protected double basicSalary;

    public Employee(String name, int empId, double basicSalary) {
        this.name = name;
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void displaySalary() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Total Salary: $" + calculateSalary());
    }
}

class Professor extends Employee {
    private double researchAllowance;

    public Professor(String name, int empId, double basicSalary, double researchAllowance) {
        super(name, empId, basicSalary);
        this.researchAllowance = researchAllowance;
    }

    public double calculateSalary() {
        return basicSalary + researchAllowance;
    }
}

class LabAssistant extends Employee {
    private double labAllowance;

    public LabAssistant(String name, int empId, double basicSalary, double labAllowance) {
        super(name, empId, basicSalary);
        this.labAllowance = labAllowance;
    }

    public double calculateSalary() {
        return basicSalary + labAllowance;
    }
}

class AdministrativeStaff extends Employee {
    private double overtimeBonus;

    public AdministrativeStaff(String name, int empId, double basicSalary, double overtimeBonus) {
        super(name, empId, basicSalary);
        this.overtimeBonus = overtimeBonus;
    }

    public double calculateSalary() {
        return basicSalary + overtimeBonus;
    }
}

public class week5qs2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        
        employees.add(new Professor("Dr. Smith", 101, 80000, 15000));
        employees.add(new LabAssistant("John", 102, 35000, 5000));
        employees.add(new AdministrativeStaff("Sarah", 103, 40000, 3000));

        for (Employee emp : employees) {
            emp.displaySalary();
        }
    }
}