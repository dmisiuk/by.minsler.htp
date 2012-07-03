package by.minsler.htp.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		Connection myConnection = null;
		ResultSet result = null;
		String listQuery = "select * from expenses";
		String deleteQuery = "delete from expenses where num=?";
		String addQuery = "insert into expenses(num,paydate,receiver,value) values(?,?,?,?)";
		String searchNumQuery = "select * from expenses where num=?";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res;

		try {
			myConnection = DriverManager.getConnection(dbURI, username,
					password);
			Statement statement = myConnection.createStatement();
			PreparedStatement prStatementDelete = myConnection
					.prepareStatement(deleteQuery);
			PreparedStatement prStatementAdd = myConnection
					.prepareStatement(addQuery);
			PreparedStatement prStatementSearch = myConnection
					.prepareStatement(searchNumQuery);
			String l = null;
			String info = "Введите необходимую операцию:\n"
					+ "1 - для вывода таблицы\n"
					+ "2 - для добавления новой записи\n"
					+ "3 - для удаления записи по номеру\n" + "0 - для выхода";
			System.out.println(info);
			while (!(l = br.readLine()).equals("0")) {
				try {
					int i = Integer.parseInt(l);
					switch (i) {
					case 1:
						statement = myConnection.createStatement();
						result = statement.executeQuery(listQuery);
						while (result.next()) {
							System.out.println(result.getString(1) + " "
									+ result.getString(2) + " "
									+ result.getString(3) + " "
									+ result.getString(4));
						}
						break;
					case 2:
						prStatementAdd.clearParameters();
						System.out
								.println("введите num, paydate, receiver, value через пробел");
						l = br.readLine();
						String s[] = l.split(" ");
						prStatementSearch.setInt(1, Integer.parseInt(s[0]));
						result = prStatementSearch.executeQuery();
						// if (result.next()) {
						// System.out
						// .println("запись с таким номером уже существует");
						// break;
						// }
						prStatementAdd.setInt(1, Integer.parseInt(s[0]));
						prStatementAdd.setString(2, s[1]);
						prStatementAdd.setInt(3, Integer.parseInt(s[2]));
						prStatementAdd.setInt(4, Integer.parseInt(s[3]));
						if ((res = prStatementAdd.executeUpdate()) == 0) {
							System.out.println("ну удалось добавить");
						}

						break;
					case 3:
						prStatementDelete.clearParameters();
						System.out.println("введите num для удаления");
						l = br.readLine();
						prStatementSearch.setInt(1, Integer.parseInt(l));
						result = prStatementSearch.executeQuery();

						if (!result.next()) {
							System.out
									.println("записи с таким номером не существует");
							break;
						}
						prStatementDelete.setInt(1, Integer.parseInt(l));

						prStatementDelete.executeUpdate();
						break;
					default:
						throw new NumberFormatException();
					}

				} catch (NumberFormatException e) {
					System.out.println("недопустимый аргумент");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("недопустимое количество аргументов");
				} finally {
					System.out.println(info);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (myConnection != null) {
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("error close");
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
