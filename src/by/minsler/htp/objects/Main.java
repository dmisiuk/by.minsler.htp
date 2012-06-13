package by.minsler.htp.objects;

public class Main {

	public static void main(String[] args) {
		long l = 154634560L;
		// MyTime mt = new MyTime(l);
		// MyTimeOther mto = new MyTimeOther(l);
		//
		// System.out.println(mt.toString());
		// System.out.println(mto);
		//

		NewTime time = new NewTime(l);

		NewTime time2 = new NewTime(43123123);

		System.out.println(time);
		System.out.println(time2);
		System.out.println(time.compareTo(time2));
		System.out.println(time.getS());
		long allSecond = time.getSeconds();
		System.out.println(allSecond);

		System.out.println(time);

		NewTime a[] = new NewTime[10];

		for (int i = 0; i < a.length; i++) {
			int bb = (int) (Math.random() * 10000000);
			a[i] = new NewTime(bb);
		}

		NewTime max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(max) > 0) {
				max = a[i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		System.out.println("max = " + max);
	}
}
