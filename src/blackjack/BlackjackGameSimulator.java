package blackjack;

public class BlackjackGameSimulator 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("0 or Enter.\t Let's try a card!");
		System.out.println("1.\t\t Let's Play!");

		System.out.println();
		Deal d = new Deal();		//Deal cards
		Play p = new Play();		//Start game
		
		d.shuffle();
		d.initHands();
		d.hands();
		p.play();
	}
}