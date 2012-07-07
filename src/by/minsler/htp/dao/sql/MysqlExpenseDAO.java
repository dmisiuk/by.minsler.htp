package by.minsler.htp.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.ExpenseDAO;

public class MysqlExpenseDAO implements ExpenseDAO {

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

	public MysqlExpenseDAO() {
		connection = MysqlConnection.getInstance().getConnection();
		System.out.println("connection got");
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
		selectAllStatement = connection.createStatement();
		ArrayList<Expense> list = new ArrayList<Expense>();
		ResultSet result = selectAllStatement.executeQuery(SELECT_ALL);
		while (result.next()) {
			Expense expense = new Expense();
			expense.setNum(result.getInt("num"));
			expense.setPaydate(result.getDate("paydate"));
			expense.setReceiver(result.getInt("receiver"));
			expense.setValue(result.getInt("value"));
			list.add(expense);
		}
		return list;
	}

	@Override
	public Expense getExpense(int num) throws SQLException {
		selectByNumStatement = connection.prepareStatement(SELECT_BY_NUM);
		selectByNumStatement.clearParameters();
		selectByNumStatement.setInt(1, num);
		ResultSet result = selectByNumStatement.executeQuery();
		if (result.next()) {
			Expense expense = new Expense(result.getInt("num"),
					result.getDate("paydate"), result.getInt("receiver"),
					result.getInt("value"));
			return expense;
		}
		return null;
	}

	@Override
	public int addExpense(Expense expense) throws SQLException {
		insertStatement = connection.prepareStatement(INSERT);
		insertStatement.clearParameters();
		insertStatement.setInt(1, expense.getNum());
		insertStatement.setDate(2, expense.getPaydate());
		insertStatement.setInt(3, expense.getReceiver());
		insertStatement.setInt(4, expense.getValue());
		int result = insertStatement.executeUpdate();
		return result;
	}

	@Override
	public int delExpense(int num) throws SQLException {
		deleteByNumStatement = connection.prepareStatement(DELETE_BY_NUM);
		deleteByNumStatement.clearParameters();
		deleteByNumStatement.setInt(1, num);
		int result = deleteByNumStatement.executeUpdate();
		return result;
	}

	@Override
	public int updateExpense(int num, Expense expense) throws SQLException {
		updateByNumStatement = connection.prepareStatement(UPDATE_BY_NUM);
		updateByNumStatement.clearParameters();
		updateByNumStatement.setDate(1, expense.getPaydate());
		updateByNumStatement.setInt(2, expense.getReceiver());
		updateByNumStatement.setInt(3, expense.getValue());
		updateByNumStatement.setInt(4, num);
		int result = updateByNumStatement.executeUpdate();
		return result;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeConnection();
	}
}
