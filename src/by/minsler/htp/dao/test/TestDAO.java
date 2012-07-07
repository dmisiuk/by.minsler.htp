package by.minsler.htp.dao.test;

import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.ExpenseDAO;
import by.minsler.htp.dao.plsql.PostgresExpenseDAO;

public class TestDAO {
	public static void main(String[] args) {

		try {
			ExpenseDAO expenseDao = new PostgresExpenseDAO();
			PostgresExpenseDAO.createConnection();
			ArrayList<Expense> list = expenseDao.getExpenses();
			for (Expense expense : list) {
				System.out.println(expense);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PostgresExpenseDAO.closeConnection();
		}
	}
}
