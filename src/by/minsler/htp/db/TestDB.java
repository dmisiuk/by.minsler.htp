package by.minsler.htp.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql jdbc driver connected");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver: " + e);
		}

		String dbURI = "jdbc:mysql://localhost:3306/minslertest";
		String username = "root";
		String password = "1234";

		try {
			DriverManager.getConnection(dbURI, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
