package by.minsler.htp.categories;

import by.minsler.htp.card.Card;

public abstract class MasterCard extends Card {

	public MasterCard(int startSum, String endDate, String type, int pin) {
		super("MaterCard", startSum, endDate, type, pin);
	}
}
