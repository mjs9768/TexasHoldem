
import java.util.Comparator;
public class Card{
    private int rank, suit;

    private static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
    private static String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};

    //Constructor
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    // Getter and Setters
    public int getSuit(){
        return suit + 1;
    }

    public int getRank(){
        return rank + 1 ;
    }

    // methods
    public static String rankAsString(int __rank){
        return ranks[__rank];
    }

    public static String suitAsString(int __suit){
        return suits[__suit];
    }

    public @Override String toString(){
        return ranks[rank] + " of " + suits[suit];
    }

    // Print card to string
    protected String printCard(){
        return ranks[rank] + " of " + suits[suit];
    }

    // Determine if two cards are the same (Ace of Diamonds == Ace of Diamonds)
    public static boolean sameCard(Card card1, Card card2){
        return (card1.rank == card2.rank && card1.suit == card2.suit);
    }   
}
   
    class rankComparator implements Comparator<Card> {
    	public int compare(Card c1, Card c2) {
    		int c1Size = c1.getRank();
    		int c2Size = c2.getRank();
     
    		if (c1Size > c2Size) {
    			return 1;
    		} else if (c1Size < c2Size) {
    			return -1;
    		} else {
    			return 0;
    		}
    	}
}
