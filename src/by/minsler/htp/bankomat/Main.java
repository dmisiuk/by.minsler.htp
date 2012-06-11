package by.minsler.htp.bankomat;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int kk[][] = { { 20, 50, 100 }, { 50, 21, 100 } };
		Bankomat bm = new Bankomat(kk);
		bm.found(480);
		bm.found(50);
		bm.found(400);
		bm.found(310);
		bm.found(450);
		bm.found(1510);
		bm.found(400);
		bm.found(310);
		bm.found(450);
		bm.found(400);
		bm.found(310);
		bm.found(450);
		bm.found(400);
		bm.found(310);
		bm.found(450);
		bm.found(400);
		bm.found(310);
		bm.found(450);

	}
}
