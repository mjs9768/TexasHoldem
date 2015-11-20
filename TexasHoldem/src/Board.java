import java.util.ArrayList;
import java.util.Collections;

public class Board {


	public static void main(String[] args) {
		int i = 0;
		while (i < 100){
		int chips = 100000;
		JoeSchmoe joe = new JoeSchmoe(chips);
		MoneyBags money = new MoneyBags(chips);
		CheapSkate cheap = new CheapSkate(chips);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(joe);
		players.add(money);
		players.add(cheap);
			while(players.size()> 1){
				Dealer dealer = new Dealer();
				dealer.blinds(players);
				dealer.dealStartingHand(players);
				dealer.betting(players);
				dealer.theFlop(players);
				dealer.betting(players);
				dealer.theRiver(players);
				dealer.betting(players);
				dealer.theTurn(players);
				dealer.betting(players);
				dealer.findWinner(players);
				players.clear();
				if(cheap.getChips()>= 20){
					players.add(cheap);
				}
				if(joe.getChips()>= 20){
					players.add(joe);
				}
				if(money.getChips()>= 20){
					players.add(money);
				}
				Collections.shuffle(players);
		}
	
		System.out.println(joe + "chips won " + joe.getChipsWon());
		System.out.println(cheap + "chips won " + cheap.getChipsWon());
		System.out.println(money + "chips won " + money.getChipsWon());
		System.out.println(joe + "Hands won " + joe.getHandsWon());
		System.out.println(cheap + "Hands won " + cheap.getHandsWon());
		System.out.println(money + "Hands won " + money.getHandsWon());
		System.out.println(joe + "current chips " + joe.getChips());
		System.out.println(cheap + "current chips " + cheap.getChips());
		System.out.println(money + "current chips " + money.getChips());
		System.out.println(joe + "hands Played" + ((double) joe.getHandsWon()/joe.getPlayedHands()));
		System.out.println(cheap + "Hands played " + ((double)cheap.getHandsWon()/cheap.getPlayedHands()));
		System.out.println(money + "Hands Played " + ((double)money.getHandsWon()/money.getPlayedHands()));
		System.out.println("*********************************************");
	}
		i++;
	}

}
