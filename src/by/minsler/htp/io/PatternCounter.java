package by.minsler.htp.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCounter {

	private Map<String, Integer> elements = new TreeMap<String, Integer>();

	public Map<String, Integer> count(String str, Pattern pattern) {
		if (str == null || pattern == null) {
			// TODO for null variable?
		}
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			Integer freq = elements.get(matcher.group());
			elements.put(matcher.group(), (freq == null) ? 1 : freq + 1);
		}
		return elements;
	}

	public Map<String, Integer> count(BufferedReader br, Pattern pattern)
			throws IOException {
		String l;
		while ((l = br.readLine()) != null) {
			this.count(l, pattern);
		}
		return elements;
	}

	public void clearCounter() {
		elements.clear();
	}

}