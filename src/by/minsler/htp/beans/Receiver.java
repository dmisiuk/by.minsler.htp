package by.minsler.htp.beans;

public class Receiver {

	private static int nextId = 0;
	private int num;
	private String name;

	public Receiver() {
		num = nextId++;
	}

	public Receiver(String name) {
		this.name = name;
		num = nextId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

}
