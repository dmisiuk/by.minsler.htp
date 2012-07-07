package by.minsler.htp.beans;

public class Expense {

	private int num;
	private String paydate;
	private int receiver;
	private int value;

	public Expense() {
	}

	public Expense(int num, String paydate, int receiver, int value) {
		this.receiver = receiver;
		this.paydate = paydate;
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		return "num: " + this.getNum() + ", paydate: " + this.getPaydate()
				+ ", receiver: " + this.getReceiver() + ", value: "
				+ this.getValue();
	}

}
