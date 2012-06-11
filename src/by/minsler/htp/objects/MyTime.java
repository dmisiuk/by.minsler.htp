package by.minsler.htp.objects;

public class MyTime {

	private long sec;
	private long seconds;
	private long min;
	private long minutes;
	private long h;
	private long hours;
	private long d;

	public MyTime(long sec) {
		this.sec = sec;
	}

	private void calculate() {
		seconds = sec % 60;
		min = (sec - seconds) / 60;
		minutes = min % 60;
		h = (min - minutes) / 60;
		hours = h % 24;
		d = (h - hours) / 24;
	}

	public MyTime add(MyTime time) {
		this.sec = this.sec + time.sec;
		return this;
	}

	public MyTime substract(MyTime time) {
		this.sec = this.sec - time.sec;
		return this;
	}

	@Override
	public String toString() {
		this.calculate();
		return d + " day(s), " + hours + " hour(s), " + minutes
				+ " minute(s), " + seconds + " second(s)";
	}

}
