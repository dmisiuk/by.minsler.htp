package by.minsler.htp.dao.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.minsler.htp.command.AdderExpenseCommand;
import by.minsler.htp.command.AdderReceiverCommand;
import by.minsler.htp.command.Command;
import by.minsler.htp.command.DeleterExpenseCommand;
import by.minsler.htp.command.DeleterReceiverCommand;
import by.minsler.htp.command.PrintExpenseCommand;
import by.minsler.htp.command.PrintExpensesCommand;
import by.minsler.htp.command.PrintReceiverCommand;
import by.minsler.htp.command.PrintReceiversCommand;

public class InteractiveTestDao {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res;

		try {

			String l = null;
			String info = "Введите необходимую операцию:\n"
					+ "1 - для вывода платежей\n"
					+ "2 - для вывода платежа по номеру\n"
					+ "3 - для добавления нового платежа\n"
					+ "4 - для удаления платежа по номеру\n"
					// + "5 - для замены платежа по номеру\n"
					+ "6 - для вывода получателей\n"
					+ "7 - для вывода получателя по номеру\n"
					+ "8 - для добавления нового получателя\n"
					+ "9 - для удаления платежа по номеру\n"
					// + "10 - для замены получателя по номеру\n"
					+ "0 - для выхода";
			System.out.println(info);
			Command command = null;
			while (!(l = br.readLine()).equals("0")) {
				try {
					int i = Integer.parseInt(l);
					switch (i) {
					case 1:
						command = new PrintExpensesCommand();
						break;
					case 2:
						command = new PrintExpenseCommand();
						break;
					case 3:
						command = new AdderExpenseCommand();
						break;
					case 4:
						command = new DeleterExpenseCommand();
						break;
					// case 5:
					//
					// break;
					case 6:
						command = new PrintReceiversCommand();
						break;
					case 7:
						command = new PrintReceiverCommand();
						break;
					case 8:
						command = new AdderReceiverCommand();
						break;
					case 9:
						command = new DeleterReceiverCommand();
						break;
					// case 10:
					//
					// break;
					default:
						throw new NumberFormatException();
					}
					command.execute();

				} catch (NumberFormatException e) {
					System.out.println("недопустимый аргумент");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("недопустимое количество аргументов");
				} finally {
					System.out.println(info);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
