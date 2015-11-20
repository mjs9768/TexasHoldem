import java.util.ArrayList;

public class HandEval { 
	Hand currentHand = new Hand();
	// Constructor
	public HandEval(Hand h){
		currentHand = h;   
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
				//System.out.println("cards needed " + cardsNeeded);
				percentage = percentage * (cardsNeeded/cardsLeft);
				cardsNeeded--;
				cardsLeft--;
				//System.out.println("percent " +  percentage);
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
		int j = 0;
		while(j<4){
			int i =0;
			int z = 0;
			int x = 0;
			int k =0;
			while (k<currentHand.handSize()){ // putting in hand all of same suit
				if (currentHand.get(k).getSuit() == j+1){
					goodCards.addToHand(currentHand.get(k));
					k++;
				}
				else{
					k++;
				}
			}
			goodCards.sortByRank();
			ArrayList<Integer> binaryArray = new ArrayList<Integer>();
			while (x< 14){
				binaryArray.add(1);
				x++;
			}
			while (i < goodCards.handSize()){
				int replace = goodCards.get(i).getRank()-1;
				binaryArray.set(replace, 0);
				i++;
			}
			while (z < binaryArray.size()-4){
				int totalCardsNeeded = binaryArray.get(z) + binaryArray.get(z+1) 
					+ binaryArray.get(z+2) + binaryArray.get(z+3) + binaryArray.get(z+4);
				if (totalCardsNeeded == 0){
					percent = 1;
					return percent;
				}
				if (totalCardsNeeded == 1){
					percent = percent + (1.0/(52.0 - currentHand.handSize()));
				}
				if(totalCardsNeeded == 2 && currentHand.handSize() < 6){
					percent = percent + (1.0/(52.0 - currentHand.handSize()) * (4.0/(51.0 - currentHand.handSize())));
				}
				z++;
			}
			goodCards.clear();
			j++;
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
		currentHand.sortByRank();
		int x = 0;
		int i = 0;
		double percent = 0;
		while (x < currentHand.handSize()- 2){ // if 3 cards are the same
			if (currentHand.get(x).getRank() == currentHand.get(x+2).getRank()){
				while (i < currentHand.handSize()){
					if (currentHand.get(i).getRank() == currentHand.get(i+1).getRank()){
						percent = 1;
						return percent;
					}
					i++;
				}
			}
			x++;
		}
		if(twoPairsPercent() == 1.0){
			percent = (2.0/13.0);
			return percent;
		}
		if (threeOfKindPercent() == 1.0 && currentHand.handSize() <= 6){
			percent = ((currentHand.handSize()-3)/13.0);
			return percent;
		}
		if(pairPercent() == 1 && currentHand.handSize() == 5){
			percent = (3.0/13.0) * (1.0/13.0)*(1.0/12.0);
			return percent;
		}
		return percent;
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
		ArrayList<Integer> binaryArray = new ArrayList<Integer>();
		int x = 0; 
		int i = 0;
		int z = 0;
		double percent = 0;
		while (x< 14){
			binaryArray.add(1);
			x++;
		}
		while (i < currentHand.handSize()){
			int replace = currentHand.get(i).getRank();
			binaryArray.set(replace, 0);
			i++;
		}
		while (z < binaryArray.size()-4){
			int totalCardsNeeded = binaryArray.get(z) + binaryArray.get(z+1) 
				+ binaryArray.get(z+2) + binaryArray.get(z+3) + binaryArray.get(z+4);
			if (totalCardsNeeded == 0){
				percent = 1;
				return percent;
			}
			if (totalCardsNeeded == 1){
				percent = percent + (4.0/(52.0 - currentHand.handSize()));
			}
			if(totalCardsNeeded == 2 && currentHand.handSize() < 6){
				percent = percent + (4.0/(52.0 - currentHand.handSize()) * (4.0/(51.0 - currentHand.handSize())));
			}
			z++;
		}
		return percent;
	}
	public double threeOfKindPercent(){
		currentHand.sortByRank();
		int x = 0;
		int i = 0;
		double percent = 0;
		while (x < currentHand.handSize()- 2){ // if 3 cards are the same
			if (currentHand.get(x).getRank() == currentHand.get(x+2).getRank()){
				percent = 1;
				return percent;
			}
			x++;
		}
		while(i< currentHand.handSize()-1){ // looking for pairs
			if(currentHand.get(i).getRank() == currentHand.get(i+1).getRank()){
				percent = (2/(52 - currentHand.handSize()));
				return percent;
			}
			i++;
		}
		percent = (2/(52-currentHand.handSize())) * (1 / 51 - (currentHand.handSize()));
		return percent;
	}
	public double twoPairsPercent(){
		currentHand.sortByRank();
		int x = 0;
		double percent = 0;
		int pairs = 0;
		while (x < currentHand.handSize()- 1){ // if 2 cards are the same
			if (currentHand.get(x).getRank() == currentHand.get(x+1).getRank()){
				pairs += 1;
				x++;
			}
			x++;
		}
		if (pairs == 2){
			percent = 1;
			return percent; 
		}
		if (pairs == 1){
			percent = (currentHand.handSize() - 2)/13;
			return percent;
		}
		if (currentHand.handSize() == 5){
			percent = ((5.0/13.0) * (4.0/13.0));
			return percent;
		}
		return percent;
	}
	public double pairPercent(){
		currentHand.sortByRank();
		int x = 0;
		double percent = 0;
		while (x < currentHand.handSize()- 1){ // if 3 cards are the same
			if (currentHand.get(x).getRank() == currentHand.get(x+1).getRank()){
				percent = 1;
				return percent;
			}
			x++;
		}
			percent = (currentHand.handSize() / 13.0);
		return percent;
	}
	public double highCardPercent(){
		currentHand.sortByRank();
		double percent = 0;
		percent = currentHand.get(currentHand.handSize()-1).getRank() * .0714;
		return percent;
		
	}
}
