public class GamePlay extends GameLogic{

    GameData p = new Player("Abhiyan", 0);
    static GameData d = new Dealer();
    Deck deck = new Deck(1);

    public void start(int betAmount){

        deck.suffle();
        System.out.println(deck);
        ((Player)p).addBet(betAmount);

        for(int i = 0 ; i <=1; i++){
            draw(p, deck);
            draw(d, deck);
            if(totalPlayerValue() == 21)
                blackJack();
        }
    }

    public int totalPlayerValue(){
       return getValue(p, deck);
    }

    public void blackJack(){
        System.out.println("BLACKJACK!!!");
        System.out.println("Player Won as his total is 21.");
        ((Player)p).win(1.5);
    }

    public int totalDealerValue(){
        return getValue(d, deck);
     }

    public void playerAddFunds(int balance){
        ((Player)p).setBalance(betAmount);
    }

    public void PlayerWin(){
        ((Player)p).win(1);
        System.out.println("Players Total Balance: " + ((Player)p).getBalance());
    }

    public void DealerWin(){
        ((Player)p).loss();
        System.out.println("Players Total Balance: " + ((Player)p).getBalance());
    }

    public void playerBust(){
        System.out.println("Players total card value is more than 21");
        System.out.println("Player looses.");
        ((Player)p).loss();
        System.out.println("Players Total Balance: " + ((Player)p).getBalance());
    }

    public void showDrawn(){
        System.out.println("Player Cards: " + showDrawn(p));
        System.out.println("Dealer Cards: " + showDrawn(d));
    }

    public void getResult(){
        if (totalPlayerValue() > 21){
            playerBust();
        }

        else if (totalDealerValue() > 21){
            System.out.println("Dealer total card value is more than 21");
            PlayerWin();
        }

        
        else if(totalPlayerValue() > totalDealerValue()){
            System.out.println("Player Wins");
            PlayerWin();
        }
        else{
            System.out.println("Dealer Won");
            DealerWin();
        }
    }
}