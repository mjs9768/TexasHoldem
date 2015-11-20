import java.util.ArrayList;

public class CheapSkate extends Player {
	
	public CheapSkate(int startingChips) {
		super(startingChips);
		percents =  new ArrayList<Double>();
		baseBet = 5;

		eval = new HandEval(hand);

	}

	private ArrayList<Double> percents;
	int baseBet;
	HandEval eval;

	public void getPercents(){
		clearPercents();
		percents.add(eval.highCardPercent());
		percents.add(eval.pairPercent());
		percents.add(eval.twoPairsPercent());
		percents.add(eval.threeOfKindPercent());
		percents.add(eval.straightPercent());
		percents.add(eval.flushPercent());
		percents.add(eval.fullHousePercent());
		percents.add(eval.fourKindPercent());
		percents.add(eval.straightFlushPercent());
		percents.add(eval.royalFlushPercent());
		
	}
	public int highestHand(){
		getPercents();
		int x = 0;
		int index = 0;
		while(x < percents.size()){
			if(percents.get(x)== 1){
				index =x;
				x++;
			}
			x++;
		}
		return index;
	}
	
	public void clearPercents(){
		percents.clear();
	}
	public int yourBet(){
		int yourbet = 0;
		int x = 0;
		if(hand.handSize() == 2){
			StartingHandRank rankOfHand = new StartingHandRank(hand);
			if(rankOfHand.getRank() == 1){
				yourbet = baseBet * 25;
				if(getChips()<= yourbet ){
					return getChips();
				}
				return yourbet;
			}
			if(rankOfHand.getRank() <= 2){
				return 0;
			}
			
			yourbet = baseBet * rankOfHand.getRank();
			if(getChips() <yourbet ){
				return getChips();
			}
			return yourbet;
		}
		while (x < percents.size()){
			yourbet = (int) (baseBet * percents.get(x) * x*5);
			x++;
		}
		if(yourbet == getChips()*.75){
			yourbet = getChips();
		}
		if(getChips()>yourbet){
			return 0;
		}
		return yourbet;
	}
	public int betFoldCall(int bet){
		int yourbet = yourBet();
		if(yourbet < bet-75 || yourbet ==0){
			return -1;
		}
		if(yourbet > bet+30){
			return yourbet;
		}
		if(bet == 0){
			return baseBet;
		}
		return bet;
	}
	
	public int play(int currentBet){
		int yourbet = betFoldCall(currentBet);
		if (yourbet == -1){
			return 0;
		}
		return yourbet;
		
	}
			
			
}	
			
			
	
	