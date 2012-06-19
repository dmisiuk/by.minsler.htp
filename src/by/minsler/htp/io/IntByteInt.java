package by.minsler.htp.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntByteInt {

	public static void main(String[] args) {

		String fileName = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream out = null;
		DataInputStream in = null;
		String l = null;

		try {
			System.out.println("Please, enter file name for output:");
			fileName = br.readLine();
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(fileName)));

			System.out
					.println("enter number and press \"enter\" or enter 0 for exit:");
			while ((l = br.readLine()).length() > 0 && l.charAt(0) != '0') {
				int i;
				i = Integer.parseInt(l);
				out.writeInt(i);
			}
			System.out.println("Reading finished");

		} catch (FileNotFoundException e) {
			System.out.println("file" + fileName + " not found");
		} catch (NumberFormatException e) {
			System.out.println(l + " is not number");
		} catch (IOException e) {
			System.out.println("read error from system.in");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("error of closing file: " + fileName);
				}
			}
		}

		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(fileName)));
			while (in.available() > 3) {
				System.out.println(in.readInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("file" + fileName + " not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("error of closing file: " + fileName);
				}
			}
		}

	}
}
