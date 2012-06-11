package by.minsler.htp.objects;

public class Main {

	public static void main(String[] args) {
		long l = 100230042L;
		MyTime mt = new MyTime(l);
		MyTimeOther mto = new MyTimeOther(l);

		System.out.println(mt.toString());
		System.out.println(mto);

	}
}
