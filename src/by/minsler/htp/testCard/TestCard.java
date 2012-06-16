package by.minsler.htp.testCard;

import by.minsler.htp.card.Card;
import by.minsler.htp.concretecard.MaestroClassic;
import by.minsler.htp.concretecard.VisaElectron;
import by.minsler.htp.concretecard.VisaGold;

public class TestCard {

	public static void main(String[] args) {
		VisaElectron ve = new VisaElectron(200, "12/12/2015", "семейная");
		VisaGold vg = new VisaGold(300, "17/01/2050", "пенсионная");
		MaestroClassic mc = new MaestroClassic(0, "12/17/2011", "зарплатная");

		Card[] cards = new Card[3];
		cards[0] = ve;
		cards[1] = vg;
		cards[2] = mc;

		for (Card card : cards) {
			System.out.println(card);
		}

		for (Card card : cards) {
			card.takeSum(250);
		}
	}
}
