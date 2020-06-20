package blackjack;

public class Deal extends Cards {
static  	 int h = 7 ;				 // Max number of cards
static  	 int h = 7 ;				 // Max number of cards
static  	 int [] player =  new  int [h];		 // array of player's hand
static  	 int [] com =  new  int [h];		 // array of Computer's hands
static 	 int P = 0;				// player's array number
static 	 int C = 0;
 	 char x;				 // Argument for distinguishing between player and computer

	void  flip ( char  x ) {			 // Card one card
						// Computer if argument c, Player if p
		if (MAX < h*2)
			shuffle();
		for (int i = 0; i < 1; i++) {
			int n = (int) (Math.random() * 52) + 1;
			if (cards [n] !=  99 ) {		 // 99 is assigned as a sign
				if (x == 'p') {
					player[P] = n;
					P++;
				}
				if (x == 'c') {
					com[C] = n;
					C++;
				}
				cards [n] =  99 ;	 // assign 99 as an indicator
				MAX--;
			} else
				i--;
		}
	}

	void  hands () {				 // Defer card first
		flip('c');
		flip('p');
		flip('c');
		info();
	}

	void  shuffle () {			 // shuffle cards
		System.out.println( " shuffle card " );
		MAX = 52;
		cards_m();
	}

	void yourHand() {
		for (int b = 0; b < player.length; b++) {
			if (player[b] != 0)
				System.out.print(cards_m[player[b]] + " ");
		}
		System.out.println();
	}
	
	void comHand() {
		for (int b = 0; b < com.length; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	<you> void  comHand(int i ) {
		for (int b = 0; b < i; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	void  initHands () {			 // initialize your hand
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
			com [i] =  0 ;
			P = 0;
			C = 0;
		}
	}

	int  cal ( char  i ) {			 // Hand calculation
		int[] n = player;
		if (i == 'c')			//'c' for computer
			n = com;
		if (i == 'p')			//'p' for player
			n = player;

		int p =  0 ;
		for (int d : n) {
			if (d == 0)
				p += 0;
			if (d >= 1 && d <= 9)
				p += d;
			if (d >= 10 && d <= 13)
				p += 10;
			if (d >= 14 && d <= 22)
				p += d - RANK;
			if (d >= 23 && d <= 26)
				p += 10;
			if (d >= 27 && d <= 35)
				p += d - RANK * 2;
			if (d >= 36 && d <= 39)
				p += 10;
			if (d >= 40 && d <= 48)
				p += d - RANK * 3;
			if (d >= 49 && d <= 52)
				p += 10;
		}
		return p;
	}

	void  info () { // debugging
	// comment the lines out which you like to know about.
//	 show();
//	 show_s();
//	 System.out.println();
// 	 System.out.println ("Remaining card =" + MAX);
//	 System.out.println();

		System.out.print(" Computer: ");
		comHand(1); 
		System.out.print( " Your hand: " );
		yourHand(); 

		System.out.println ( " Total of your card = "  + cal ( 'p' )); 
	}

}