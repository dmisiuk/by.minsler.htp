package by.minsler.htp.dao.plsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.ExpenseDAO;

public class PostgresExpenseDAO implements ExpenseDAO {

	private static String userName = "testuser";
	private static String password = "1234";
	private static String jdbcDriver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/listexpenses";
	private static Connection connection = null;

	public static final String SELECT_ALL = "SELECT * FROM expenses";
	public static final String SELECT_BY_NUM = "SELECT * FROM expenses WHERE num=?";
	public static final String INSERT = "INSERT INTO expenses(num,paydate,receiver,value) VALUES(?,?,?,?)";
	public static final String DELETE_BY_NUM = "DELETE FROM expenses WHERE num=?";
	public static final String UPDATE_BY_NUM = "UPDATE expenses SET paydate=?, receiver=?, value=? WHERE num=?";

	private static Statement selectAllStatement = null;
	private static PreparedStatement selectByNumStatement = null;
	private static PreparedStatement insertStatement = null;
	private static PreparedStatement deleteByNumStatement = null;
	private static PreparedStatement updateByNumStatement = null;

	synchronized public static void createConnection() {
		if (connection == null) {
			try {
				Class.forName(jdbcDriver);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage() + " driver not found");
			}
			try {
				connection = DriverManager.getConnection(url, userName,
						password);
				System.out.println("connection established");
				createStatements();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static void closeConnection() {
		if (connection != null) {
			System.out.print("Closing connection: ");
			try {
				connection.close();
				System.out.println("success");
				connection = null;
			} catch (SQLException e) {
				System.out.println("error " + e.getMessage());
			}
		}
	}

	private static void createStatements() throws SQLException {
		selectAllStatement = connection.createStatement();
		selectByNumStatement = connection.prepareStatement(SELECT_BY_NUM);
		insertStatement = connection.prepareStatement(INSERT);
		deleteByNumStatement = connection.prepareStatement(DELETE_BY_NUM);
		updateByNumStatement = connection.prepareStatement(UPDATE_BY_NUM);

	}

	@Override
	public ArrayList<Expense> getExpenses() throws SQLException {
		ArrayList<Expense> list = new ArrayList<Expense>();
		ResultSet result = selectAllStatement.executeQuery(SELECT_ALL);
		while (result.next()) {
			Expense expense = new Expense();
			expense.setNum(result.getInt("num"));
			expense.setPaydate(result.getString("paydate"));
			expense.setReceiver(result.getInt("receiver"));
			expense.setValue(result.getInt("value"));
			list.add(expense);
		}
		return list;
	}

	@Override
	public Expense getExpense(int num) {
		return null;
	}

	@Override
	public int addExpense(Expense expense) {
		return 0;
	}

	@Override
	public int delExpense(int num) {
		return 0;
	}

	@Override
	public int updateExpense(int num, Expense expense) {
		return 0;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeConnection();
	}
}
