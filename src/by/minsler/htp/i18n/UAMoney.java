package by.minsler.htp.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class UAMoney {
	public static void main(String[] args) {
		double money = 153.5;
		Locale uaLocale = new Locale("uk", "UA");

		NumberFormat nf = NumberFormat.getCurrencyInstance(uaLocale);
		System.out.println(nf.format(money));
	}
}
