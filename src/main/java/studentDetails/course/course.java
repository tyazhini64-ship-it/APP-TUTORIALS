package studentDetails.course;

public class course {
    private int cId;
    private String cName;
    private int credits;

    public course(int cId,String cName,int credits ){
        this.cId = cId;
        this.cName = cName;
        this.credits = credits;
    }

    public void displayCourseDetails(){
        System.out.println("Course ID: " + cId);
        System.out.println("Course Name: " + cName);
        System.out.println("Course Department: " + credits);
    }
    
}
