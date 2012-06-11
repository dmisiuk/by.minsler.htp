package by.minsler.htp.objects;

public class MyTimeOther {

	private long fullSeconds;

	public MyTimeOther(long fullSeconds) {
		this.fullSeconds = fullSeconds;
	}

	public MyTimeOther add(MyTimeOther time) {
		this.fullSeconds = this.fullSeconds + time.fullSeconds;
		return this;
	}

	public MyTimeOther substract(MyTimeOther time) {
		this.fullSeconds = this.fullSeconds - time.fullSeconds;
		return this;
	}

	public void setFullSeconds(long fullSeconds) {
		this.fullSeconds = fullSeconds;
	}

	public long getFullSeconds() {
		return fullSeconds;
	}

	public long getSeconds() {
		return fullSeconds % 60;
	}

	public long getMinutes() {
		long m = (fullSeconds - getSeconds()) / 60;
		return m % 60;
	}

	public long getHours() {
		long m = (fullSeconds - getSeconds()) / 60;
		long h = (m - getMinutes()) / 60;
		return h % 24;
	}

	public long getDays() {
		long m = (fullSeconds - getSeconds()) / 60;
		long h = (m - getMinutes()) / 60;
		long d = (h - getHours()) / 24;
		return d;
	}

	@Override
	public String toString() {
		return getDays() + " day(s), " + getHours() + " hour(s), "
				+ getMinutes() + " minute(s), " + getSeconds() + " second(s)";
	}
}
