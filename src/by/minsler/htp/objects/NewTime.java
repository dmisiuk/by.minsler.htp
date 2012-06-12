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

	public int compareTo(NewTime param) {
		if (this.h > param.h) {
			return 1;
		} else if (this.h < param.h) {
			return -1;
		}

		if (this.m > param.m) {
			return 1;
		} else if (this.m < param.m) {
			return -1;
		}

		if (this.s > param.s) {
			return 1;
		} else if (this.s < param.s) {
			return -1;
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
