package by.minsler.htp.command;

import java.util.ArrayList;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class PrintExpensesCommand implements Command {

	@Override
	public void execute() {
		ArrayList<Expense> list = MysqlExpenseReceiverDAO.getInstance()
				.getExpenses();
		for (Expense expense : list) {
			System.out.println(expense);
		}
	}
}
