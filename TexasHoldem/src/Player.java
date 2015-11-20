
public abstract class Player {
	int chips;
	int handsWon;
	int chipsWon;
	Hand hand;
	int handsPlayed;
	public Player(int startingChips){
		chips = startingChips;
		handsWon = 0;
		chipsWon = 0;
		hand = new Hand();
		handsPlayed = 0;
	}
	public abstract void getPercents();
	/**
	 * @return the chips
	 */
	public int getChips() {
		return chips;
	}
	public abstract int highestHand();
	/**
	 * @param chips the chips to set
	 */
	public void addChips(int c) {
		chips = chips + c;
		chipsWon = chipsWon + c;
		handsWon++;
	}
	public void removeChips(int c){
		if(chips - c < 0){
			chips = 0;
		}
		else{
			chips = chips -c;
		}
	}
	/**
	 * @return the handsWon
	 */
	public int getHandsWon() {
		return handsWon;
	}
	/**
	 * @param handsWon the handsWon to set
	 */
	public void setHandsWon(int handsWon) {
		this.handsWon = handsWon;
	}
	/**
	 * @return the chipsWon
	 */
	public int getChipsWon() {
		return chipsWon;
	}
	/**
	 * @param chipsWon the chipsWon to set
	 */
	public void setChipsWon(int chipsWon) {
		this.chipsWon = chipsWon;
	}
	abstract int play(int currentBet);
	public int getPlayedHands(){
		return handsPlayed;
		
	}
}