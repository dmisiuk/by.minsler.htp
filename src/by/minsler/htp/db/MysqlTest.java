package by.minsler.htp.db;

import java.sql.SQLException;
import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.ExpenseDAO;
import by.minsler.htp.dao.plsql.MysqlExpenseDAO;

public class MysqlTest {
	public static void main(String[] args) throws SQLException {
		ExpenseDAO expenseDao = new MysqlExpenseDAO();

		ArrayList<Expense> list = expenseDao.getExpenses();
		for (Expense expense : list) {
			System.out.println(expense);
		}
		MysqlExpenseDAO.closeConnection();
	}

}
