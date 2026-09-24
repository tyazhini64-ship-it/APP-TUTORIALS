package studentDetails.student;

public class student {
    private int sId;
    private String name;
    private String dept;

    public student(int sId,String name,String dept ){
        this.sId = sId;
        this.name = name;
        this.dept = dept;
    }

    public void displayStudentDetails(){
        System.out.println("Student ID: " + sId);
        System.out.println("Student Name: " + name);
        System.out.println("Student Department: " + dept);

    }

}