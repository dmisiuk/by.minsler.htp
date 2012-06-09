package by.minsler.htp.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWord {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;

		System.out.println("Please, enter string: ");
		str = br.readLine();
		int num = 0;
		boolean current = false;
		String word = "";
		String maxWord = "";
		str = str + " ";

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp >= 'a' && temp <= 'z' || temp == '-') {
				current = true;
				word = word + temp;
			} else if (current) {
				num++;
				current = false;
				System.out.println(word);
				if (word.length() > maxWord.length()) {
					maxWord = word;
				}
				word = "";
			}
		}

		System.out.println("num = " + num);
		System.out.println("Max word=" + maxWord);
	}
}
