public class GameLogic{

    public void setValue(GameData gamer, Deck deck){
        int value = 0;
        boolean AceFlag = false;
        for(String myCard : gamer.myCards()){
            if(myCard.matches(".*ACE$")){
                AceFlag = true;
                continue;
            }
            value += deck.getValue(myCard);
        }
        if(AceFlag)
            value += valueOfAce(value);
        gamer.setTotalCardValue(value);
    }

    private int valueOfAce(int value){
        if(value + 11 > 21)
            return 1;        
        return 11;
    }

    public int getValue(GameData gamer, Deck deck){
        setValue(gamer, deck);
        return gamer.getTotalCardValue();
    }

    public void draw(GameData gamer, Deck deck){
        String card = deck.draw();
        gamer.drawCard(card);
    }

    public String showDrawn(GameData gamer){
        return gamer.toString();
    }

}