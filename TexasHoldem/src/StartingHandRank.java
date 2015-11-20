
public class StartingHandRank {
	int handRank = 4;
	public StartingHandRank(Hand h){
		if(h.get(0).getRank() == h.get(1).getRank()){
			handRank = 1;
		}
		if(h.get(0).getSuit()== h.get(1).getSuit()){
			handRank = handRank - 1;
		}
		if(h.get(0).getRank()+ h.get(1).getRank() >= 20){
			handRank = handRank - 2;
		}
		if(h.get(0).getRank()+ h.get(1).getRank() >= 13){
			handRank = handRank -1;
		}
	}
	public int getRank(){
		return handRank;
		
	}
}
