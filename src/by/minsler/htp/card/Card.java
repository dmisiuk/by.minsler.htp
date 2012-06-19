package by.minsler.htp.card;

public abstract class Card {

	private int currentSum;
	private String endDate;
	private String category;
	private String type;
	protected int pin;

	public Card(String category, int startSum, String endDate, String type,
			int pin) {
		this.category = category;
		this.currentSum = startSum;
		this.endDate = endDate;
		this.type = type;
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Current sum:" + currentSum + " end date: " + endDate
				+ " Category: " + category + " type:" + type;
	}

	public int getCurrentSum() {
		return currentSum;
	}

	public void addSum(int sum) {
		currentSum += sum;
	}

	public boolean takeSum(int sum) {
		if (currentSum > sum) {
			currentSum -= sum;
			return true;
		}
		return false;
	}

	public abstract String getDescription();

}
