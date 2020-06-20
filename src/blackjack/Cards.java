package blackjack;

public class Cards {
    static int cards[]; // card by unique id
    static String cards_m[]; // cards_mark
    static String cards_s[]; // cards_status
    final int RANK = 13; // number of cards per type
    int MAX = RANK * 4; // number of cards

    // String[] mark = { "♥", "♠", "♣", "♦" };

    // ♥　♠　◆　♣ ❤　♦
    void cards() { // initiate cards!
		   // Add a mark to play cards

	cards = new int[MAX + 1]; // card 52 + 1. 0 is a joker (not used)
	for (int i = 0; i < cards.length; i++) {
	    cards[i] = i;
	}
    }

    void cards_m() {
	cards();
	// トランプカード
	cards_m = new String[MAX + 1];
	String[] mark = { "♥", "♠", "♣", "♦" };

	for (int i = 0; i < RANK * 4 + 1; i++) {
	    if (i < RANK + 1) {
		cards_m[i] = "♥" + cards[i];
	    } else if (i < RANK * 2) {
		cards_m[i] = "♠" + (cards[i] - RANK);
	    } else if (i < RANK * 3) {
		cards_m[i] = "♣" + (cards[i] - RANK * 2);
	    } else {
		cards_m[i] = "♦" + (cards[i] - RANK * 3);
	    }
	}

	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK - 2] = mark[i - 1] + "J";
	}
	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK - 1] = mark[i - 1] + "Q";
	}
	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK] = mark[i - 1] + "K";
	}
	cards_m[0] = ""; // Joker cards_m[0]
    }

    void show() { // show cards by ID
	int i = 0;
	for (int d : cards) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

    void show_m() { // show card symbol
	cards_s = new String[cards.length];
	for (int i = 0; i < cards.length; i++) {
	    cards_s[i] = cards_m[i];
	}

	int i = 0;
	for (String d : cards_s) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

    void show_s() { // show cards with symbol and status
	cards_s = new String[cards.length];
	for (int i = 0; i < cards.length; i++) {
	    cards_s[i] = cards_m[i];
	}

	for (int i = 0; i < cards.length; i++) {
	    if (cards[i] == 99)
		cards_s[i] = "@@";
	}

	int i = 0;
	for (String d : cards_s) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

}
