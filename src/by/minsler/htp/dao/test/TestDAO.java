package by.minsler.htp.dao.test;

import java.sql.Date;
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

			System.out.println(expenseDao.getExpense(10));

			int res = expenseDao.addExpense(new Expense(7, new Date(System
					.currentTimeMillis()), 2, 76000));

			list = expenseDao.getExpenses();
			for (Expense expense : list) {
				System.out.println(expense);
			}

			expenseDao.delExpense(7);

			list = expenseDao.getExpenses();
			for (Expense expense : list) {
				System.out.println(expense);
			}

			Expense oldExpense = expenseDao.getExpense(2);
			Expense newExpense = new Expense(10, new Date(
					System.currentTimeMillis()), 5, 72000);
			expenseDao.updateExpense(2, newExpense);

			list = expenseDao.getExpenses();
			for (Expense expense : list) {
				System.out.println(expense);
			}

			expenseDao.updateExpense(2, oldExpense);
			list = expenseDao.getExpenses();
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
