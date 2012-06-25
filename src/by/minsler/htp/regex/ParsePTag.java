package by.minsler.htp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsePTag {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("(<p[^>]*>)");
		String text = "<p asdlkajsd;lk > asdfj;laksd asd </p>  alsdkfja;lskd <p asdf /> ;kj <p id=\"1\" > ";
		System.out.println("Before: \n" + text);

		System.out.println("After:");
		String newText;
		newText = text.replaceAll("(<p[^>]*>)", "<p>");

		System.out.println(newText);
		Matcher m = p.matcher(text);
		// System.out.println(m.replaceAll("<p>"));

		StringBuilder sb = new StringBuilder();
		int start = 0;

		while (m.find()) {
			int startGroup = m.start();
			sb.append(text.substring(start, startGroup));
			sb.append("<p>");
			start = m.end();
		}

		System.out.println("sb : " + sb);
	}
}
