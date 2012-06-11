package by.minsler.htp.bankomat;

public class Bankomat {

	int n;
	int kupury[];
	int kol[];
	double step[];
	double iterator[];
	int sum;
	int trat[];

	public Bankomat(int[][] kupuryKol) {
		n = kupuryKol[0].length;
		kupury = kupuryKol[0];
		kol = kupuryKol[1];
		step = new double[n];
		iterator = new double[n];
		trat = new int[n];
	}

	private void setStep() {
		int max = getmax();
		for (int i = 0; i < step.length; i++) {
			step[i] = (double) kol[i] / max;
		}
	}

	private int getmax() {
		int max = kol[0];
		for (int i = 0; i < kol.length; i++) {
			if (kol[i] > max) {
				max = kol[i];
			}
		}
		return max;
	}

	public void found(int sum) {
		this.sum = sum;
		setStep();
		int i = 0;
		int mySum = 0;
		int empty = 0;
		trat = new int[n];
		iterator = new double[n];
		while (sum > mySum && empty < n) {
			if (Math.floor(iterator[i] + step[i]) > Math.floor(iterator[i])) {
				iterator[i] = iterator[i] + step[i];
				if (kol[i] > 0) {
					mySum = mySum + kupury[i];
					kol[i]--;
					trat[i]++;
					empty = 0;
				} else {
					empty++;
				}
			} else {

				iterator[i] = iterator[i] + step[i];
			}

			if (i == n - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		System.out.println("MySum = " + mySum);
		for (int j = 0; j < trat.length; j++) {
			System.out.println(kupury[j] + ": " + trat[j] + " осталось "
					+ kol[j]);
		}
	}
}
