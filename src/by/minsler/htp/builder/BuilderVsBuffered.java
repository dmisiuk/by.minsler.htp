package by.minsler.htp.builder;

import java.io.IOException;
import java.util.Calendar;

public class BuilderVsBuffered {

	public static void main(String[] args) throws IOException {
		StringBuilder sBuilder = new StringBuilder();
		StringBuffer sBufferd = new StringBuffer();
		testTime(sBuilder, 1000000);
		testTime(sBufferd, 1000000);
		testTime("", 100000);
	}

	public static void testTime(Appendable string, int times)
			throws IOException {
		Calendar timeStarts = Calendar.getInstance();
		for (int i = 0; i < times; i++) {
			string.append((char) i);
		}
		Calendar timeEnd = Calendar.getInstance();
		System.out.println("time: "
				+ (timeEnd.getTimeInMillis() - timeStarts.getTimeInMillis()));
	}

	public static void testTime(String string, int times) throws IOException {
		Calendar timeStarts = Calendar.getInstance();
		for (int i = 0; i < times; i++) {
			string = string + (char) i;
		}
		Calendar timeEnd = Calendar.getInstance();
		System.out.println("time: "
				+ (timeEnd.getTimeInMillis() - timeStarts.getTimeInMillis()));
	}

}
