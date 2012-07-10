package by.minsler.htp.dao.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import by.minsler.htp.beans.Expense;
import by.minsler.htp.beans.Receiver;
import by.minsler.htp.dao.ExpenseReceiverDAO;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class MysqlExpenseReceiverTest {
	public static void main(String[] args) {

		ExpenseReceiverDAO erdao = MysqlExpenseReceiverDAO.getInstance();

		ArrayList<Expense> list = erdao.getExpenses();
		System.out.println("list expenses in table");
		for (Expense expense : list) {
			System.out.println(expense);
		}
		ArrayList<Receiver> listReceivers = erdao.getReceivers();

		for (Receiver receiver : listReceivers) {
			System.out.println(receiver);
		}

		Receiver newReceiver = new Receiver(7, "Камары");
		System.out.println(erdao.addReceiver(newReceiver));

		listReceivers = erdao.getReceivers();

		for (Receiver receiver : listReceivers) {
			System.out.println(receiver);
		}

		Receiver receiverK = erdao.getReceiver(7);
		receiverK.setName("Коморовский рынок");
		erdao.updateReceiver(receiverK.getNum(), receiverK);
		listReceivers = erdao.getReceivers();

		for (Receiver receiver : listReceivers) {
			System.out.println(receiver);
		}

		Expense expenseTwo = erdao.getExpense(2);
		System.out.println(expenseTwo);
		Calendar date = new GregorianCalendar(2010, 0, 10);
		expenseTwo.setPaydate(new Date(date.getTime().getTime()));
		System.out.println(expenseTwo);
		erdao.updateExpense(2, expenseTwo);
		System.out.println(erdao.getExpense(2));
	}
}
