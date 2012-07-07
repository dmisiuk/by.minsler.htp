package by.minsler.htp.dao;

import java.util.ArrayList;

import by.minsler.htp.beans.Receiver;

public interface ReceiverDAO {

	ArrayList<Receiver> getReceivers();

	Receiver getReceiver(int num);

	int addReceiver(Receiver receiver);

	int delReceiver(int num);

	int updateReceiver(int num, Receiver receiver);

}
