package by.minsler.htp.beans;

public class Expense {

	private static int nextId = 0;
	private int num;
	private String paydate;
	private int receiver;
	private int value;

	public Expense() {
		num = nextId++;
	}

	public Expense(String paydate, int receiver, int value) {
		this.receiver = receiver;
		this.paydate = paydate;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNum() {
		return num;
	}

}
