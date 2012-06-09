package by.minsler.htp.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PunctualSymbol {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;

		System.out.println("Please, enter string: ");
		str = br.readLine();
		int num = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.' || str.charAt(i) == ','
					|| str.charAt(i) == '?' || str.charAt(i) == '!') {
				num++;
			}
		}

		System.out.println("num = " + num);
	}

}
