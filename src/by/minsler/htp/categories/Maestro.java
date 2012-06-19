package by.minsler.htp.categories;

import by.minsler.htp.card.Card;

public abstract class Maestro extends Card {

	public Maestro(int startSum, String endDate, String type, int pin) {
		super("Maestro", startSum, endDate, type, pin);
	}

}
