package by.minsler.htp.beans;

public class Expense {

	private static int nextId = 0;
	private int num;
	private String paydate;
	private int receiver;

	public Expense(String paydate, int receiver) {
		this.receiver = receiver;
		this.paydate = paydate;
		num = nextId++;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getNum() {
		return num;
	}

}
