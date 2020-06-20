package blackjack;

import lib.Input;

public class Play extends Deal {

    void play() {
	while (true) {
	    switch (Input.getInt()) {
	    case 0:
		flip('p');
		info();

		if (cal('p') == 21) {
		    sleep(500);
		    System.out.println("!!!!!!!!! BLACKJACK !！!!!!!\n");
		    winlose();
		    break;
		}

		if (cal('p') > 21)
		    winlose();
		break;
	    case 1:
		winlose();
		break;

	    case 2:
		show();
		break;

	    case 3:
		show_m();
		break;

	    case 4:
		show_s();
		break;
	    }

	    System.out.println();
	}
    }

    void winlose() {
	while (true) {
	    if (cal('p') > 21) {
		sleep(500);
		System.out.println("Bust!!!");
		System.out.println("Computer Wins!!! Play Again");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > 21) {
		System.out.print("Computer");
		comHand(h);
		System.out.println(" Computer cards = " + cal('c') + " Bust！");
		cal('c');
		sleep(500);
		System.out.println(" You Win!!! ");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > cal('p') && cal('c') < 22) {
		System.out.print("Computer ");
		comHand(h);
		System.out.println("Computer cards = " + cal('c'));
		sleep(500);
		System.out.println(" Computer Wins!!! ");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') == cal('p')) {
		System.out.print("Computer");
		comHand(h);
		System.out.println("Computer cards = " + cal('c'));
		System.out.println("It's a draw!!!");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    System.out.print("Computer ");
	    comHand(h);
	    System.out.println("Computer cards = " + cal('c'));
	    sleep(1000);

	    if (cal('c') < cal('p')) {
		flip('c');
	    }


	}
    }

    void sleep(int i) {

	try {
	    Thread.sleep(i);
	} catch (InterruptedException e) {
	    // TODO auto-generated catch block
	    e.printStackTrace();
	} // Sleep

    }
}
//@