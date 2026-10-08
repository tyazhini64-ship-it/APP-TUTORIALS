class EmergencyAlert extends Thread{
    public void run(){
        System.out.println(getName()+" priority "+getPriority());
        System.out.println(getName()+"is running");
        }
}

class VitalSigns extends Thread{
    public void run(){
        System.out.println(getName()+" priority "+getPriority());
        System.out.println(getName()+" is running");
        }
}

class ReportGeneration extends Thread{
    public void run(){
        System.out.println(getName()+" priority "+getPriority());
        System.out.println(getName()+" is running ");
        }
}
class week8qs1{
    public static void main(String args[]){
        EmergencyAlert e1=new EmergencyAlert();
        VitalSigns v1=new VitalSigns();
        ReportGeneration r1=new ReportGeneration();
        e1.setPriority(Thread.MAX_PRIORITY);
        v1.setPriority(Thread.NORM_PRIORITY);
        r1.setPriority(Thread.MIN_PRIORITY);
        e1.start();
        v1.start();
        r1.start();
    }
}