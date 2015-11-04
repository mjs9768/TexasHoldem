
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hand testHand = new Hand();
		Card card1 = new Card(14,2);
		Card card2 = new Card(11,2);
		Card card3 = new Card(12,2);
		testHand.addToHand(card1);
		testHand.addToHand(card2);
		testHand.addToHand(card3);
		HandEval eval = new HandEval(testHand);
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(eval.straightFlushPercent());
	}

}
