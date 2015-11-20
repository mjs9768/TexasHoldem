import java.util.ArrayList;
import java.util.Collections;


public class Deck{
	private ArrayList<Card> deck;

    //Constructor
    public Deck(){
    	deck = new ArrayList<Card>();
        for (int j=0; j<4; j++){
            for (int k=0; k<13;k++){
                deck.add(new Card(k, j));    
            }
        }
    }

    // Print entire deck in order
    protected void printDeck(){
        for(int i=0; i<deck.size();i++){
            System.out.println(i+1 + ": " + deck.get(i).printCard());
        }
        System.out.println("\n");
    }

    // Find card in deck in a linear fashion
    // Use this method if deck is shuffled/random
    protected int findCard(Card card){
        for (int i=0;i<52;i++){
            if (Card.sameCard(deck.get(i), card)){
                return i;
            }
        }
        return -1;
    }
    public void burnCard(){
    	deck.remove(0);
    }

    //return specified card from deck
    protected Card getCard(){
        return deck.get(0);
    }

    protected void shuffle(){
    	Collections.shuffle(deck);
    }
}