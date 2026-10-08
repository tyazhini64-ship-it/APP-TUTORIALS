class OrderProcessing extends Thread {
    public void run(){
        System.out.println("Processing order: " + getName() + " with priority: " + getPriority());
        System.out.println(getName() + " is running");
    }   
}

class DeliveryTracking extends Thread {
    public void run(){
        System.out.println("Tracking delivery: " + getName() + " with priority: " + getPriority());
        System.out.println(getName() + " is running");
    }   
}
class NotificationService extends Thread {
    public void run(){
        System.out.println("Sending notification: " + getName() + " with priority: " + getPriority());
        System.out.println(getName() + " is running");
    }   
}

public class week8qs2 {
    public static void main(String args[]){
        OrderProcessing o1 = new OrderProcessing();
        DeliveryTracking d1 = new DeliveryTracking();
        NotificationService n1 = new NotificationService();
        
        o1.setPriority(Thread.MAX_PRIORITY);
        d1.setPriority(Thread.NORM_PRIORITY);
        n1.setPriority(Thread.MIN_PRIORITY);
        
        o1.start();
        d1.start();
        n1.start();
    }
}
