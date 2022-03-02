import java.util.LinkedList;
import java.util.Scanner;

public class Player extends GameData{

    private int betAmount;
    private double balance = 0;
    private String name;
    private final int INIT_BALANCE = 100;

    public Player(){
        this.name = "Player";
        this.balance = INIT_BALANCE;
    }

    public Player(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    public void setBalance(double balance){
        this.balance += balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void win(double times){
        this.balance += betAmount  * times;
    } 

    public boolean isBankrupt(){
        return balance == 0 ;
    }

    public void loss(){
        this.balance -= betAmount;
    }


    public void addBet(int bet){
        if(isBankrupt()){
            System.out.println("You don't have enough balance to place the bet.");
            depostOrExit(bet);
        }
        else if(bet > this.balance){
            System.out.println("Bet amount is greater than current balance. You can add upto " + balance + " only");
            depostOrExit(bet);
        }
        else{
            betAmount = bet;
        }
    }

    public void addExtrabet(int betAmount){
        
    }

    public String toString(){
        return drawnCard.toString();
    }

    private void depostOrExit(int bet){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you like to add Funds or exit the game? ");
        System.out.println("Enter 1 to add the funds.");
        System.out.println("Enter 2 to exit the game.");
        System.out.print("=>");
        int response = 0;
        try{
            response = scan.nextInt();
            if(response != 1 || response !=  2){
                throw new Exception("Please enter 1/2 only");
            }
        }
        catch (Exception e){
            System.out.println("Please enter 1/2 only");
        }
        if(response == 1){
            System.out.println("How much do you want to depost? ");
            System.out.print("=> $ ");
            double amount = 0 ;
            try{
                amount = scan.nextDouble();
                setBalance(amount);
                System.out.println("Deposit Successfull. Your new balance is $" + balance );
                if(balance > bet)
                    return;
                else{
                    System.out.println("Your Balance is still less than bet amount.");
                    depostOrExit(bet);
                }
            }
            catch (Exception e){
                System.out.println("Please enter amount in digit only.");
            }
        }
        else{
            System.exit(0);
        }
    }

}