
public class week2qs1 {
    public static void main (String[]args){
       Student S1;
       S1=new Student(5,"NWC","MONISH");
       S1.displayDetails();
        

    }
}

class Student{
    int rno;
    String dept;
    String name;


    Student(int rno,String dept,String name){
        this.rno=rno;
        this.dept=dept;
        this.name=name;
    }

    void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("Department: "+dept);
        System.out.println("RNO: "+rno);


    }




}