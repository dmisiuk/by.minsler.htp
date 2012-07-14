package by.minsler.htp.xml;

import java.util.HashMap;

public class SqlConfig {

	private static SqlConfig inst;

	private static final HashMap<String, String> preferences = new HashMap<String, String>();

	public static HashMap<String, String> getPrefereces() {
		return preferences;
	}

}
