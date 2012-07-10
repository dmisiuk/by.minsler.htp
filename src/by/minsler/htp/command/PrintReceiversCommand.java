package by.minsler.htp.command;

import java.util.ArrayList;

import by.minsler.htp.beans.Receiver;
import by.minsler.htp.dao.sql.MysqlExpenseReceiverDAO;

public class PrintReceiversCommand implements Command {

	@Override
	public void execute() {
		ArrayList<Receiver> list = MysqlExpenseReceiverDAO.getInstance()
				.getReceivers();
		for (Receiver receiver : list) {
			System.out.println(receiver);
		}
	}
}
