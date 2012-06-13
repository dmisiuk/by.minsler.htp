package by.minsler.htp.objects;

public class NewTime {

	private long s;
	private long m;
	private long h;

	public NewTime() {
		this(0, 0, 0);
	}

	public NewTime(long s, long m, long h) {
		this.s = s;
		this.m = m;
		this.h = h;
	}

	public NewTime(long seconds) {
		setBySeconds(seconds);
	}

	public void setBySeconds(long seconds) {
		this.s = seconds % 60;
		long min = (seconds - s) / 60;
		this.m = min % 60;
		this.h = (min - m) / 60;
	}

	public long getSeconds() {
		return (s + 60 * (m + 60 * h));
	}

	public long compareTo(NewTime param) {
		if (this.h != param.h) {
			return (this.h - param.h);
		}
		if (this.m != param.m) {
			return (this.m - param.m);
		}
		if (this.s != param.s) {
			return (this.s - param.s);
		}
		return 0;
	}

	@Override
	public String toString() {
		return h + " hour(s), " + m + " minute(s), " + s + " second(s)";

	}

	public long getS() {
		return s;
	}

	public void setS(long s) {
		this.s = s;
	}

	public long getM() {
		return m;
	}

	public void setM(long m) {
		this.m = m;
	}

	public long getH() {
		return h;
	}

	public void setH(long h) {
		this.h = h;
	}

}
