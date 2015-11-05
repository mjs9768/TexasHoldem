import java.util.ArrayList;

public class HandEval { 
	Hand currentHand = new Hand();
	// Constructor
	public HandEval(Hand h){
		currentHand = h;
		ArrayList<Double> chanceToWin = new ArrayList<Double>();    
	}
	public ArrayList<Double> evaluateHand(){
	}
	/**
	 * 
	 * 
	 * @return a double which is the percent chance for you to get a royal flush given your hand
	 */
	public double royalFlushPercent(){
		Hand goodCards = new Hand(); // we temp store all the cards that fit the description
		double percent = 0;
		int x = 0;
		int i =0;
		int z = 0;
		while(z<4){
			while (i<currentHand.handSize()){ // putting in hand all of same suit
				if (currentHand.get(i).getSuit() == z+1){
					goodCards.addToHand(currentHand.get(i));
					i++;
				}
				else{
					i++;
				}
			}
			while(x<goodCards.handSize()){ // storing all cards with rank above 10 in a new array
				if (goodCards.get(x).getRank() >= 10){
					x++;
				}
				else{
					goodCards.remove(x);
					x++;
				}
			}
			double percentage = 1;
			double cardsNeeded =  5 - goodCards.handSize();
			double cardsLeft = 52 - currentHand.handSize();
			if (cardsNeeded == 0){ // if we have all 5 cards break and pass 1 we got it
				percent = 1;
				break;
			}
			while (cardsNeeded > 0){	// calc odds to chance to get royal
				System.out.println("cards needed " + cardsNeeded);
				percentage = percentage * (cardsNeeded/cardsLeft);
				cardsNeeded--;
				cardsLeft--;
				System.out.println("percent " +  percentage);
			}
			x =0;
			i = 0;
			percent = percent + percentage;
			z++;
			goodCards.clear();
		}
		if (percent < .000001) // removes impossible small scenarios 
			return 0.0;
		return percent;
	}
	public double straightFlushPercent(){
		Hand goodCards = new Hand(); // we temp store all the cards that fit the description
		double percent = 0;
		int i =0;
		int z = 0;
		int x = 0;
		int missingCards = 0;
		while(z<4){
			while (i<currentHand.handSize()){ // putting in hand all of same suit
				if (currentHand.get(i).getSuit() == z+1){
					goodCards.addToHand(currentHand.get(i));
					i++;
				}
				else{
					i++;
				}
			}
			goodCards.sortByRank();
			if((goodCards.handSize() >= 5) && (goodCards.get(4).getRank() - (goodCards.get(0).getRank()+4) == 0)){
				percent = 1.0;
				return percent;
			}
			while(x < (goodCards.handSize()-1)){
				if (goodCards.get(x).getRank() == (goodCards.get(x+1).getRank() - 1)){
					x++;
				}
				else{
					missingCards++;
					x++;
				}
			}
			double cardsLeft = 52 - currentHand.handSize();
			double percentage = 1;
			while (missingCards > 0){	// calc odds to chance to get straight flush
				percentage = percentage * (missingCards/cardsLeft);
				System.out.println("percent " +  percentage);
				missingCards--;
				cardsLeft--;
				percent = percent + percentage;
			}
			missingCards = 0;
			x = 0;
			i = 0;
			System.out.println("percent here to -" + percent );
			z++;
			goodCards.clear();
		}
		return percent;
	}	
	public double fourKindPercent(){
		currentHand.sortByRank();
		int x = 0;
		int i = 0;
		int j = 0;
		double percent = 0;
		while (x < currentHand.handSize()- 3){ // if 4 cards are the same
			if (currentHand.get(x).getRank() == currentHand.get(x+3).getRank()){
				percent = 1;
				return percent;
			}
			x++;
		}
		while (i < currentHand.handSize()- 2){ // if three cards
			if (currentHand.get(i).getRank() == currentHand.get(i+2).getRank()){
				percent = (1.0 / (52 - currentHand.handSize()));
				return percent;
			}
			i++;
		}
		while (j < currentHand.handSize()- 1){ // if 2 cards
			if (currentHand.get(j).getRank() == currentHand.get(j+1).getRank()){
				percent = (1.0 / (52 - currentHand.handSize())) * (1.0 / (51 - currentHand.handSize()));
				return percent;
			}
			j++;
		}
		return percent;
	}
	public double fullHousePercent(){
	}
	public double flushPercent(){
		Hand goodCards = new Hand(); // we temp store all the cards that fit the description
		double percent = 0;
		int i =0;
		int z = 0;
		while(z<4){
			while (i<currentHand.handSize()){ // putting in hand all of same suit
				if (currentHand.get(i).getSuit() == z+1){
					goodCards.addToHand(currentHand.get(i));
					i++;
				}
				else{
					i++;
				}
			}
			if(goodCards.handSize() >= 5){
				percent = 1;
				return percent;
			}
			double percentage = 1;
			double cardsNeeded =  5 - goodCards.handSize();
			double cardsLeft = 13 - currentHand.handSize();
			while (cardsNeeded > 0){	// calc odds to chance to get royal
				percentage = percentage * (cardsNeeded/cardsLeft);
				cardsNeeded--;
				cardsLeft--;
			}
			i = 0;
			percent = percent + percentage;
			z++;
			goodCards.clear();

		}
		return percent;
	}
	public double straightPercent(){
		currentHand.sortByRank();
		int x = 0;
		int i = 0;
		int j = 0;
		double percent = 0;
		while (x < currentHand.handSize()- 4){
			if ((currentHand.get(x+4).getRank() - currentHand.get(x).getRank()) == 4){
				percent = 1;
				return percent;
			}
			x++;
		}
		while (i < currentHand.handSize()- 4){
			if (currentHand.handSize() == 5){
				

			}
			i++;
		}
		
		return percent;
	}
}


