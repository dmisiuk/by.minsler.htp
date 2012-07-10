package by.minsler.htp.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.beans.Receiver;
import by.minsler.htp.dao.ExpenseReceiverDAO;

public class MysqlExpenseReceiverDAO implements ExpenseReceiverDAO {

	private static MysqlExpenseReceiverDAO inst;
	private static Connection connection;
	// MySQL
	// private static String userName = "root";
	// private static String password = "1234";
	// private static String jdbcDriverName = "com.mysql.jdbc.Driver";
	// private static String url = "jdbc:mysql://localhost:3306/minslertest";

	// PostgreSQL
	private static String userName = "testuser";
	private static String password = "1234";
	private static String jdbcDriverName = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/listexpenses";

	private MysqlExpenseReceiverDAO() {
		createConnection();
	}

	synchronized public static MysqlExpenseReceiverDAO getInstance() {
		if (inst == null) {
			inst = new MysqlExpenseReceiverDAO();
		}
		return inst;
	}

	private void createConnection() {
		try {
			Class.forName(jdbcDriverName);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("erro driver load" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("error set connection" + e.getMessage());
		}
	}

	private void closeConnection() {
		if (connection != null) {
			System.out.print("close connection: ");
			try {
				connection.close();
				System.out.println("success");
			} catch (SQLException e) {
				System.out.println("error" + e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<Expense> getExpenses() {
		ArrayList<Expense> list = new ArrayList<Expense>();
		String selectAll = "select * from expenses";
		try {
			Statement selectAllStatement = connection.createStatement();
			ResultSet result = selectAllStatement.executeQuery(selectAll);
			while (result.next()) {
				Expense expense = new Expense();
				expense.setNum(result.getInt("num"));
				expense.setPaydate(result.getDate("paydate"));
				expense.setReceiver(result.getInt("receiver"));
				expense.setValue(result.getInt("value"));
				list.add(expense);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error sql " + e.getMessage());
			return null;
		}

	}

	@Override
	public Expense getExpense(int num) {
		Expense expense = null;
		String selectByNum = "select * from expenses where num = ?";
		try {
			PreparedStatement selectByNumStatement = connection
					.prepareStatement(selectByNum);
			selectByNumStatement.setInt(1, num);
			ResultSet result = selectByNumStatement.executeQuery();
			if (result.next()) {
				expense = new Expense();
				expense.setNum(result.getInt("num"));
				expense.setPaydate(result.getDate("paydate"));
				expense.setReceiver(result.getInt("receiver"));
				expense.setValue(result.getInt("value"));

			}
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return expense;
	}

	@Override
	public int addExpense(Expense expense) {
		int result = 0;
		String insert = "insert into expenses(num, paydate, receiver, value) values(?,?,?,?)";
		try {
			PreparedStatement insertStatement = connection
					.prepareStatement(insert);
			insertStatement.setInt(1, expense.getNum());
			insertStatement.setDate(2, expense.getPaydate());
			insertStatement.setInt(3, expense.getReceiver());
			insertStatement.setInt(4, expense.getValue());
			result = insertStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int delExpense(int num) {
		int result = 0;
		String deleteByNum = "delete from expenses where num=?";
		try {
			PreparedStatement deleteByNumStatement = connection
					.prepareStatement(deleteByNum);
			deleteByNumStatement.setInt(1, num);
			result = deleteByNumStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateExpense(int num, Expense expense) {
		int result = 0;
		String updateByNum = "update expenses set paydate=?, receiver=?, value=? where num=?";
		try {
			PreparedStatement updateByNumStatement = connection
					.prepareStatement(updateByNum);
			updateByNumStatement.setInt(4, num);
			updateByNumStatement.setDate(1, expense.getPaydate());
			updateByNumStatement.setInt(2, expense.getReceiver());
			updateByNumStatement.setInt(3, expense.getValue());
			result = updateByNumStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public ArrayList<Receiver> getReceivers() {
		ArrayList<Receiver> list = new ArrayList<Receiver>();
		String selectAll = "select * from receivers";
		try {
			Statement selectAllStatement = connection.createStatement();
			ResultSet result = selectAllStatement.executeQuery(selectAll);
			while (result.next()) {
				Receiver receiver = new Receiver();
				receiver.setNum(result.getInt("num"));
				receiver.setName(result.getString("name"));
				list.add(receiver);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error sql " + e.getMessage());
			return null;
		}
	}

	@Override
	public Receiver getReceiver(int num) {
		Receiver receiver = null;
		String selectByNum = "select * from receivers where num = ?";
		try {
			PreparedStatement selectByNumStatement = connection
					.prepareStatement(selectByNum);
			selectByNumStatement.setInt(1, num);
			ResultSet result = selectByNumStatement.executeQuery();
			if (result.next()) {
				receiver = new Receiver();
				receiver.setNum(result.getInt("num"));
				receiver.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return receiver;
	}

	@Override
	public int addReceiver(Receiver receiver) {
		int result = 0;
		String insert = "insert into receivers(num, name) values(?,?)";
		try {
			PreparedStatement insertStatement = connection
					.prepareStatement(insert);
			insertStatement.setInt(1, receiver.getNum());
			insertStatement.setString(2, receiver.getName());
			result = insertStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int delReceiver(int num) {
		int result = 0;
		String deleteByNum = "delete from receivers where num=?";
		try {
			PreparedStatement deleteByNumStatement = connection
					.prepareStatement(deleteByNum);
			deleteByNumStatement.setInt(1, num);
			result = deleteByNumStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateReceiver(int num, Receiver receiver) {
		int result = 0;
		String updateByNum = "update receivers set name=? where num=?";
		try {
			PreparedStatement updateByNumStatement = connection
					.prepareStatement(updateByNum);
			updateByNumStatement.setInt(2, num);
			updateByNumStatement.setString(1, receiver.getName());
			result = updateByNumStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeConnection();
	}

}
