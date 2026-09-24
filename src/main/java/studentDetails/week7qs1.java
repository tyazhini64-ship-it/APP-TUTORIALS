package studentDetails;

import java.util.ArrayList;
import java.util.Scanner;
import studentDetails.course.course;
import studentDetails.student.student;

public class week7qs1 {
    public static void main(String [] args){
        ArrayList<student> sList= new ArrayList<>();
        ArrayList<course> cList= new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        System.out.print("\n Enter the number of students: ");
        int no=sc.nextInt();


        for(int i=0;i<no;i++){
            System.out.println("ENTER DETAILS FOR STUDENT");

        
            System.out.println("ENTER  Student iD: ");
            int sid=sc.nextInt();
            System.out.println("ENTER Student Name: ");
            String sname=sc.next();
            System.out.println("ENTER Department: ");
            String dept=sc.next();

            sList.add(new student(sid,sname,dept));


        }

        System.out.print("\n Enter the number of coursesc: ");
        int cno=sc.nextInt();

        for(int i=0;i<cno;i++){
            System.out.println("ENTER DETAILS FOR COURSE");

            System.out.println("ENTER CourseiD: ");
            int cid=sc.nextInt();
            System.out.println("ENTER Course Name: ");
            String cname=sc.next();
            System.out.println("ENTER Credits: ");
            int creds=sc.nextInt();

            cList.add(new course(cid,cname,creds));

        }

        System.out.println("\n DETAILS");

        System.out.println("\n STUDENT DETAILS");
        for(student s:sList){
            s.displayStudentDetails();
        }

        for(course c:cList){
            c.displayCourseDetails();
        }


        
    }
    
}
