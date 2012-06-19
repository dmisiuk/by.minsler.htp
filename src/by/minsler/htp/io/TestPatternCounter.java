package by.minsler.htp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;

public class TestPatternCounter {

	public static void main(String[] args) {

		Pattern patternCharcters = Pattern.compile("[a-zA-Z]"); // characters
		Pattern patternWords = Pattern.compile("[a-zA-Z]+"); // words

		Pattern pattern = patternWords;

		String str = " this is test line";
		PatternCounter pc = new PatternCounter();
		System.out.println(pc.count(str, pattern));

		pc.clearCounter();

		String fileName = null;
		BufferedReader br = null;
		Map<String, Integer> words = null;

		BufferedReader sysin = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("please enter filename for counting of ...");

			fileName = sysin.readLine();
			br = new BufferedReader(new FileReader(fileName));
			words = pc.count(br, pattern);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (words != null) {
			String result = fileName + ".count.txt";
			BufferedWriter in = null;
			try {
				in = new BufferedWriter(new FileWriter(result));
				for (Map.Entry<String, Integer> en : words.entrySet()) {
					in.write(en.getKey() + " : " + en.getValue() + '\n');
				}

			} catch (FileNotFoundException e) {
				System.out.println(fileName + " not found");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
