import java.util.LinkedList;

public class GameData{
    protected LinkedList<String> drawnCard = new LinkedList<>();
    protected int totalCardValue = 0;

    public int getTotalCardValue(){
        return totalCardValue;
    }

    public void setTotalCardValue(int value){
        this.totalCardValue = value;
    }
     
    public void drawCard(String card){
        drawnCard.add(card);
    }

    public LinkedList<String> myCards(){
        return drawnCard;
    }

}