package by.minsler.htp.categories;

import by.minsler.htp.card.Card;

public class Visa extends Card {

	protected boolean internetBank;

	public Visa(int startSum, String endDate, String type) {
		super("Visa", startSum, endDate, type);
	}

	@Override
	public String toString() {
		return super.toString() + " InternetBank: " + internetBank;
	}

}
