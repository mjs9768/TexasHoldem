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
		int missingCards = 0;
		System.out.println("percent i got here" );
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
			System.out.println("percent here to" );
			goodCards.sortByRank();
			if((goodCards.handSize() >= 5) &&
					(goodCards.get(4).getRank() - goodCards.get(0).getRank() == 0)){
				percent = 1.0;
				return percent;
			}
			if((goodCards.handSize() < (7 - currentHand.handSize()))){
				percent = 0;
			}
			System.out.println("percent i got here 3 - " + goodCards.handSize());
			while(i < goodCards.handSize()-1){
				if (goodCards.get(i).getRank() == (goodCards.get(i+1).getRank() - 1)){
					i++;
					System.out.println("percent i got here 4");
				}
				else{
					System.out.println("percent i got here 5");
					missingCards++;
					i++;
				}
			}
			if(missingCards >= 4){
				System.out.println("percent i got here 3");
				percent = 0.0;
				return percent;
			}
			double cardsLeft = 52 - currentHand.handSize();
			double percentage = 1;
			while (missingCards > 0){	// calc odds to chance to get straight flush
				System.out.println("percent " +  percentage);
				percentage = percentage * (missingCards/cardsLeft);
				missingCards--;
				cardsLeft--;
			}
			i = 0;
			percent = percent + percentage;
			z++;
			goodCards.clear();
		}
		if (percent < .000001) // removes impossible small scenarios 
			return 0.0;
		return percent;
	}	
}

