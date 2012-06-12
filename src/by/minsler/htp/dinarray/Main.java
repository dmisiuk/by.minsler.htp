package by.minsler.htp.dinarray;

public class Main {

	public static void main(String[] args) {

		DinamicArray da = new DinamicArray();
		da.add(10);
		da.add(11);
		System.out.println(da);

		for (int i = 0; i < 10; i++) {
			da.add(i);
		}

		System.out.println(da);

		da.add(200);
		System.out.println(da);
		da.add(-5, 0);
		System.out.println(da);
		da.del(5);
		System.out.println(da);
		System.out.println(da.found(200));
	}
}
