import java.util.ArrayList;


/**
 * 
 * @author Matts
 * creates a hand object which stores your players cards in a 
 * arraylist.
 * constructer does nothing
 *
 */
public class Hand {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(){
	}
	
	public void addToHand(Card c){
		hand.add(c);
	}
	public int handSize(){
		return hand.size();
	}
	public boolean isEmpty(){
		if (hand.isEmpty()){
			return true;
		}
		else{
			return false;
			}
	}
	public Card get(int x){
		return hand.get(x);
	}
	public void remove(int x){
		hand.remove(x);
	}
	public void clear(){
		hand.clear();
	}
	public void sortByRank(){
		rankComparator r1 = new rankComparator();
		hand.sort(r1);
	}

}
