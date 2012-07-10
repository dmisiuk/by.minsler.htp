package by.minsler.htp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class AdderExpenseCommand implements Command {

	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l;
		Expense expense = null;
		int result = 0;
		try {

			System.out
					.println("введите num, paydate, receiver, value через пробел");
			l = br.readLine();
			String s[] = l.split(" ");
			expense = new Expense();
			expense.setNum(Integer.parseInt(s[0]));
			expense.setReceiver(Integer.parseInt(s[2]));
			expense.setValue(Integer.parseInt(s[3]));
			String d[] = s[1].split("-");
			Calendar date = new GregorianCalendar(Integer.parseInt(d[0]),
					Integer.parseInt(d[1]) - 1, Integer.parseInt(d[2]));
			expense.setPaydate(new Date(date.getTime().getTime()));
			result = MysqlExpenseReceiverDAO.getInstance().addExpense(expense);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("неверное количество аргументов");
		} catch (NumberFormatException e) {
			System.out.println("неверный формат");
		} catch (IOException e) {
			System.out.println("io exception");
		}

		if (result == 1) {
			System.out.println("платеж успешно добавлен");
		} else {
			System.out.println("произошла ошибка при добавлении платежа");
		}

	}
}
