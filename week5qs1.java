import java.util.*;
class week5qs1{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ArrayList<BankAccount> bank=new ArrayList<>();

        System.out.println("The number of entries: ");
        int no=sc.nextInt();

        for(int i=0;i<no;i++){
            System.out.println("------------------ ENTRY "+(i+1)+" ------------------");

            System.out.println("Enter the account number: ");
            int AccNo=sc.nextInt();
            System.out.println("Enter the account holder name: ");
            String accName=sc.next();
            System.out.println("Enter the initial balance: ");
            double balance=sc.nextDouble();
            bank.add(new BankAccount(AccNo,accName,balance));
        }

        for (BankAccount b: bank){

            System.out.println("------------------ ACCOUNT DETAILS ------------------");
            System.out.println("Account Number: "+b.AccNo);
            System.out.println("Account Holder Name: "+b.accName);
            System.out.println("Enter the amount to deposit: ");
            double amount=sc.nextDouble();
            b.depositBalance(amount);
            System.out.println("Enter the amount to withdraw: ");
            double amount1=sc.nextDouble();
            b.withdrawBalance(amount1);
        }




    }
}
class BankAccount{
    int AccNo;
    String accName;
    private double balance;



    public BankAccount(int Accno,String accName,double balance){
        this.AccNo=Accno;
        this.accName=accName;
        this.balance=balance;

    }


    public void depositBalance(double amount){
        
        balance+=amount;
        System.out.println("The Updated balance: " + balance);



    }

    public void withdrawBalance(double amount){
        if(amount<balance){
            balance-=amount;
            System.out.println("The Updated balance: "+ balance);
        }
        else{
            System.out.println("Insufficient funs");
        }

    }

}