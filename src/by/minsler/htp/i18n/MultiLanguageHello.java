package by.minsler.htp.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class MultiLanguageHello {

	public static void main(String[] args) {

		String language;
		String country;

		if (args.length == 2) {
			language = args[0];
			country = args[1];

		} else {
			language = "en";
			country = "US";
		}

		Locale myLocale = new Locale(language, country);
		ResourceBundle rb = ResourceBundle.getBundle("message", myLocale);
		System.out.println(rb.getString("greeting"));
	}
}
