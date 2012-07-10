package by.minsler.htp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class PrintExpenseCommand implements Command {

	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Expense expense = null;
		int num;
		try {
			System.out.println("Введите номер платежа");
			num = Integer.parseInt(br.readLine());
			expense = MysqlExpenseReceiverDAO.getInstance().getExpense(num);
		} catch (NumberFormatException e) {
			System.out.println("неверный аргумент");
		} catch (IOException e) {
			System.out.println("io exception");
		}

		if (expense != null) {
			System.out.println(expense);
		} else {
			System.out.println("получатель с таким номером отсутствует");
		}
	}
}
