package by.minsler.htp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.minsler.htp.beans.Receiver;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class PrintReceiverCommand implements Command {

	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Receiver receiver = null;
		int num;
		try {
			System.out.println("Введите номер получателя");
			num = Integer.parseInt(br.readLine());
			receiver = MysqlExpenseReceiverDAO.getInstance().getReceiver(num);
		} catch (NumberFormatException e) {
			System.out.println("неверный аргумент");
		} catch (IOException e) {
			System.out.println("io exception");
		}

		if (receiver != null) {
			System.out.println(receiver);
		} else {
			System.out.println("получатель с таким номером отсутствует");
		}
	}
}
