package by.minsler.htp.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
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

	private static String userName = "root";
	private static String password = "1234";
	private static String jdbcDriverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/minslertest";

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delExpense(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateExpense(int num, Expense expense) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Receiver> getReceivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receiver getReceiver(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReceiver(Receiver receiver) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delReceiver(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReceiver(int num, Receiver receiver) {
		// TODO Auto-generated method stub
		return 0;
	}

}
