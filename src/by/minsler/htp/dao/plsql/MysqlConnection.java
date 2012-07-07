package by.minsler.htp.dao.plsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	private static MysqlConnection inst;

	private static String userName = "root";
	private static String password = "1234";
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/minslertest";
	private static Connection connection = null;

	private MysqlConnection() {
		createConnection();
	}

	synchronized public static MysqlConnection getInstance() {
		if (inst == null) {
			inst = new MysqlConnection();
		}
		return inst;
	}

	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("error closing connection");
			}
		}
	}

	private static void createConnection() {
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + " driver not found");
		}
		try {
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("connection established");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
