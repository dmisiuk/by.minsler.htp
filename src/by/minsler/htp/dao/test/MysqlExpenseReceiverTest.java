package by.minsler.htp.dao.test;

import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.ExpenseReceiverDAO;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class MysqlExpenseReceiverTest {
	public static void main(String[] args) {
		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();

		ArrayList<Expense> list = erdao.getExpenses();
		for (Expense expense : list) {
			System.out.println(expense);
		}

	}

}
