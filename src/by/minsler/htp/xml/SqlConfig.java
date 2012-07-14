package by.minsler.htp.xml;

import java.util.HashMap;

public class SqlConfig {

	private static SqlConfig inst;

	private static final HashMap<String, String> preferences = new HashMap<String, String>();

	private SqlConfig() {

	}

	synchronized public static SqlConfig getInstance() {
		if (inst == null) {
			inst = new SqlConfig();
		}
		return inst;
	}

	synchronized public HashMap<String, String> getPrefereces() {
		return preferences;
	}

}
