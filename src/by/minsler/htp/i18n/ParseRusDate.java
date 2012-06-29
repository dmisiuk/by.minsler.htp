package by.minsler.htp.i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ParseRusDate {

	public static void main(String[] args) throws IOException {
		Locale ruLocale = new Locale("ru", "RU");
		Date now = new Date();

		DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT,
				ruLocale);
		DateFormat dfMedium = DateFormat.getDateInstance(DateFormat.MEDIUM,
				ruLocale);
		DateFormat dfFull = DateFormat.getDateInstance(DateFormat.FULL,
				ruLocale);

		System.out.println(dfShort.format(now));
		System.out.println(dfMedium.format(now));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean condition = false;
		String str = null;
		Date d = null;
		dfShort.setLenient(false);
		dfMedium.setLenient(false);
		while (d == null) {
			System.out.println("Введите дату в русском варианте");
			str = br.readLine();
			try {
				d = dfShort.parse(str);
			} catch (ParseException e) {
				System.out.println("not short");
				try {
					d = dfMedium.parse(str);
				} catch (ParseException e2) {
					System.out.println("not medium");
				}
			}
		}
		System.out.println("Ваша дата:" + dfFull.format(d));
	}
}
