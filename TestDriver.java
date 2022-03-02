public class TestDriver{
    public static void main(String[] args){
        GamePlay game = new GamePlay();
        game.start(1);
        game.showDrawn();
        System.out.println("Total Player card Value: " + game.totalPlayerValue());
        System.out.println("Total Dealer card Value: " + game.totalDealerValue());

        game.getResult();
        

    }
}