
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hand testHand = new Hand();
		Card card1 = new Card(14,2);
		Card card2 = new Card(11,2);
		Card card3 = new Card(13,2);
		Card card4 = new Card(12,2);
		Card card5 = new Card(12,3);
		Card card6 = new Card(10,4);
		testHand.addToHand(card1);
		testHand.addToHand(card2);
		testHand.addToHand(card3);
		testHand.addToHand(card4);
		testHand.addToHand(card5);
		testHand.addToHand(card6);
		HandEval eval = new HandEval(testHand);
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		System.out.println(card6);
		System.out.println(eval.straightFlushPercent());
	}

}
