package by.minsler.htp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("(0[xX])[0-9A-Fa-f]+");
		// System.out.println(0X2324);
		Matcher m = p.matcher("asdl asdfkl;asdjl ;kl qwe a0xx32 0x239 0xaf23");

		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
