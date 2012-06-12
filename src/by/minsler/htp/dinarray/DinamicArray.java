package by.minsler.htp.dinarray;

public class DinamicArray {

	private int capacity;
	private int a[];
	private int lastIndex = -1;

	public DinamicArray(int capacity) {
		this.capacity = capacity;
		a = new int[capacity];
	}

	public DinamicArray() {
		this(5);
	}

	public void add(int num) {

		if (lastIndex == capacity - 1) {
			increase();
		}
		lastIndex++;
		a[lastIndex] = num;
	}

	public void add(int num, int index) {
		if (index > lastIndex || index < 0) {
			System.out.println("за пределами массива");
			return;
		}
		if (lastIndex == capacity - 1) {
			increase();
		}
		for (int i = lastIndex; i > index; i--) {
			a[i + 1] = a[i];
		}
		a[index] = num;
		lastIndex++;
	}

	public int getLast() {
		return a[lastIndex];
	}

	public int get(int index) {
		if (index > lastIndex || index < 0) {
			System.out.println("за пределами массива");
			return 0;
		}
		return a[index];
	}

	public void del(int index) {
		if (index > lastIndex || index < 0) {
			System.out.println("за пределами массива");
			return;
		}
		for (int i = index; i < lastIndex; i++) {
			a[i] = a[i + 1];
		}
		lastIndex--;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < lastIndex + 1; i++) {
			str.append(a[i] + " ");
		}
		return str.toString();
	}

	public int found(int num) {
		for (int i = 0; i < lastIndex + 1; i++) {
			if (num == a[i]) {
				return i;
			}
		}
		return -1;
	}

	private void increase() {
		int aNew[] = new int[capacity * 2];
		for (int i = 0; i < a.length; i++) {
			aNew[i] = a[i];
		}
		capacity = capacity * 2;
		a = aNew;
	}

}
