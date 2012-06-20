package by.minsler.htp.testcard;

import by.minsler.htp.card.Card;
import by.minsler.htp.concretecard.MaestroClassic;
import by.minsler.htp.concretecard.VisaElectron;
import by.minsler.htp.concretecard.VisaGold;

public class TestCard {

	public static void main(String[] args) {
		VisaElectron ve = new VisaElectron(200, "12/12/2015", "семейная", 1234);
		VisaGold vg = new VisaGold(300, "17/01/2050", "пенсионная", 2344);
		MaestroClassic mc = new MaestroClassic(0, "12/17/2011", "зарплатная",
				2343);

		Card[] cards = { ve, vg, mc };

		for (Card card : cards) {
			System.out.println(card);
		}

		for (Card card : cards) {
			card.takeSum(250);
		}

		MaestroClassic newCard = new MaestroClassic(230, "23/23/120",
				"lubimaia", 3352);
		newCard.changePin(2343);
	}
}
