import java.util.Scanner;

public class week1qs6 {
    public static void main (String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.println("-------------MOVIE THEATRE SEAT CHECKER-------------");
        int seatNo;

        System.out.print("Enter your seat number: ");
        seatNo=sc.nextInt();

        if(seatNo % 2 == 0){
            System.out.println("Seat number " + seatNo + " is EVEN.");
        }else{
            System.out.println("Seat number " + seatNo + " is ODD.");
        }

        System.out.println("-----------------------------------------------------");
    }
}