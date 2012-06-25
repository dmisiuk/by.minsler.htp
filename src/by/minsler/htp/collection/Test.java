package by.minsler.htp.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Object m = new Object();

		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> evenNummbers = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			numbers.add((int) (Math.random() * 10));
		}

		System.out.println("All numbers:" + numbers);

		for (Integer num : numbers) {
			if (num % 2 == 0) {
				evenNummbers.add(num);
			}
		}

		System.out.println("Even numbers:" + evenNummbers);

		Set<Integer> uniqies = new HashSet<Integer>();
		Set<Integer> dups = new HashSet<Integer>();

		for (Integer num : numbers) {
			if (!uniqies.add(num)) {
				dups.add(num);
			}
		}

		Set<Integer> superUniqies = new HashSet<Integer>(uniqies);
		superUniqies.removeAll(dups);

		System.out.println("Unique numbers: " + uniqies);
		System.out.println("Duplicate numbers: " + dups);
		System.out.println("Numbers without duplicate: " + superUniqies);

	}
}
