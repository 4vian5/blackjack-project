import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Deck{

    private ArrayList<String> deck = new ArrayList<String>();
    private LinkedHashMap<String, String> deckMap = new LinkedHashMap<String, String>();

    public Deck(int noOfDecks){
        for(int i =0; i<noOfDecks; i++){
            for(Card.Suit suit : Card.Suit.values()){
                for(Card.CardNumber cardNumbers : Card.CardNumber.values()){
                    deck.add((new Card(cardNumbers, suit)).toString());
                    deckMap.put((new Card(cardNumbers, suit)).toString(), cardNumbers.getValue());
                }
            }
        }
    }

    public void suffle(){
        Collections.shuffle(deck);
    }

    public String draw(){
        String drawn = deck.get(0);
        deck.remove(0);
        return drawn;
    }

    public int getValue(String myCard){
        String value = deckMap.get(myCard);
        return Integer.parseInt(value);
    }

    public String toString(){
        System.out.println(deckMap);
        return deck.toString();
    }
}