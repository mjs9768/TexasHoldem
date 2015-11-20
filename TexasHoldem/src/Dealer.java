import java.util.ArrayList;

public class Dealer {
	
	private Deck deck;
	private int pot;//the pot on the table
	private int currentBet;
	
	
	public Dealer(){
		deck = new Deck();
		deck.shuffle();
		pot = 0;
	}
	public void findWinner(ArrayList<Player> player){
		//System.out.println("pot " + pot);
		if(pot == 0){
			return;
		}
		if (player.size() == 1){
			player.get(0).addChips(pot);
			player.get(0).handsPlayed++; 
		}
		else if (player.size() == 2){
			player.get(0).handsPlayed++; 
			player.get(1).handsPlayed++; 
			if(player.get(0).highestHand() > player.get(1).highestHand()){
				player.get(0).addChips(pot);
			}
			else if (player.get(0).highestHand() == player.get(1).highestHand()){
				player.get(0).addChips(pot/2);
				player.get(1).addChips(pot/2);
			}
			else{
				player.get(1).addChips(pot);
			}
		}
		else{
			player.get(0).handsPlayed++; 
			player.get(1).handsPlayed++; 
			player.get(2).handsPlayed++; 
			if(player.get(0).highestHand()> player.get(1).highestHand() && player.get(0).highestHand()>player.get(2).highestHand()){
				player.get(0).addChips(pot);
			}
			else if(player.get(1).highestHand()> player.get(0).highestHand() && player.get(1).highestHand()>player.get(2).highestHand()){
				player.get(1).addChips(pot);
			}
			else if(player.get(2).highestHand()> player.get(0).highestHand() && player.get(2).highestHand()>player.get(1).highestHand()){
				player.get(2).addChips(pot);
			}
			else{
				player.get(0).addChips(pot/3);
				player.get(1).addChips(pot/3);
				player.get(2).addChips(pot/3);
			}	
			
		}
		pot = 0;
		int x = 0;
		while (x < player.size()){
			player.get(x).hand.clear();
			x++;}
		deck = new Deck();
		currentBet = 0;
	}
	
	
	public void dealStartingHand(ArrayList<Player> player){
		int x = 0;
		int i = 0;
		currentBet = 0;
		deck.shuffle();
		while(x < player.size()){
			player.get(x).hand.addToHand(deck.getCard());
			x++;
			deck.burnCard();
		}
		deck.burnCard();
		while(i < player.size()){
			player.get(i).hand.addToHand(deck.getCard());
			i++;
			deck.burnCard();
		}
	}
	
	public void theFlop(ArrayList<Player> player){
		currentBet = 0;
		int x = 0;
		int i = 0;
		int z = 0;
		deck.shuffle();
		while(x < player.size()){
			player.get(x).hand.addToHand(deck.getCard());
			x++;
		}
		deck.burnCard();
		while(i < player.size()){
			player.get(i).hand.addToHand(deck.getCard());
			i++;
		}
		deck.burnCard();
		while(z < player.size()){
			player.get(z).hand.addToHand(deck.getCard());
			z++;
		}
	}
	
	public void theTurn(ArrayList<Player> player){
		currentBet = 0;
		int x =0;
		while(x < player.size()){
			player.get(x).hand.addToHand(deck.getCard());
			x++;
		}
		deck.burnCard();
		
	}
	
	public void theRiver(ArrayList<Player> player){
		currentBet = 0;
		int x =0;
		while(x < player.size()){
			player.get(x).hand.addToHand(deck.getCard());
			x++;
		}
		deck.burnCard();
	}
	
	
	public void blinds(ArrayList<Player> player){
		pot = 0;
		int x =0;
		if(player.size() == 1){
			return;
		}
		while(x < player.size()){
			if(player.get(x).getChips() - 20 <= 0){
				player.remove(x);
				x++;
			}
			else{
			player.get(x).removeChips(20);
			pot = pot +20;
			x++;
			}
		}
	}

	public int getPot(){
		return pot;
	}
	
	public void setPot(int chips){
		pot += chips;
	}

	public void betting(ArrayList<Player> player){
		int x =0;
		int first =0;
		int second = 0;
		int third = 0;
		while(x < player.size()){
			int temp = player.get(x).play(currentBet);
			//int first = player.get(x).play(currentBet);

			if(temp >= player.get(x).getChips()){
				currentBet = temp;
				player.get(x).removeChips(player.get(x).getChips());
				pot = pot + temp;
			}
			if(player.size()==1){
				break;
			}
			if(temp == -1){
				player.remove(x);
			}
			else{
			currentBet = currentBet + temp;
			player.get(x).removeChips(currentBet);
			x++;
			pot = pot + currentBet;
			}
		}
	}
		
}
