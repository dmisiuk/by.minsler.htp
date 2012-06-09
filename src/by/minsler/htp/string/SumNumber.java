package by.minsler.htp.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;

		System.out.println("Please, enter strin g: ");
		str = br.readLine();
		int num = 0;
		boolean current = false;
		String word = "";
		long sum = 0;
		str = str + " ";

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp >= '0' && temp <= '9') {
				current = true;
				word = word + temp;
			} else if (current) {
				num++;
				current = false;
				System.out.println(word);
				int number = 0;
				for (int j = 0; j < word.length(); j++) {
					number = 10 * number + (word.charAt(j) - '0');
				}
				sum = sum + number;
				word = "";
			}
		}

		System.out.println("num = " + num);
		System.out.println("sum=" + sum);
	}
}
