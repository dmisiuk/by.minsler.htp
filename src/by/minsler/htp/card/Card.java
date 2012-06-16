package by.minsler.htp.card;

public class Card {

	private int currentSum;
	private String endDate;
	private String category;
	private String type;

	public Card(String category, int startSum, String endDate, String type) {
		this.category = category;
		this.currentSum = startSum;
		this.endDate = endDate;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Current sum:" + currentSum + " end date: " + endDate
				+ " Category: " + category + " type" + type;
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

}
