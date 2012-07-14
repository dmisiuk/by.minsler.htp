package by.minsler.htp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.minsler.htp.beans.Receiver;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class AdderReceiverCommand implements Command {

	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l;
		Receiver receiver = null;
		int result = 0;
		try {

			System.out.println("введите num, name через пробел");
			l = br.readLine();
			String s[] = l.split(" ");
			receiver = new Receiver();
			receiver.setNum(Integer.parseInt(s[0]));
			receiver.setName(s[1]);
			result = MysqlExpenseReceiverDAO.getInstance()
					.addReceiver(receiver);
			System.out.println(receiver);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("неверное количество аргументов");
		} catch (NumberFormatException e) {
			System.out.println("неверный формат");
		} catch (IOException e) {
			System.out.println("io exception");
		}
		if (result == 1) {
			System.out.println("получатель успешно добавлен");
		} else {
			System.out.println("произошла ошибка при добавлении");
		}

	}
}
