package by.minsler.htp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class DeleterReceiverCommand implements Command {

	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int num;
		try {
			System.out.println("Введите номер получателя для удаления");
			num = Integer.parseInt(br.readLine());
			result = MysqlExpenseReceiverDAO.getInstance().delReceiver(num);
		} catch (NumberFormatException e) {
			System.out.println("неверный аргумент");
		} catch (IOException e) {
			System.out.println("io exception");
		}

		if (result > 0) {
			System.out.println("получатель успешно удален");
		} else {
			System.out.println("произошла ошибка при удалении получателя");
		}
	}
}
