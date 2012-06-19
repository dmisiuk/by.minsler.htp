package by.minsler.htp.categories;

import by.minsler.htp.card.Card;

public abstract class Visa extends Card {

	protected boolean internetBank;

	public Visa(int startSum, String endDate, String type, int pin) {
		super("Visa", startSum, endDate, type, pin);
	}

	@Override
	public String toString() {
		return super.toString() + " InternetBank: " + internetBank;
	}

}
