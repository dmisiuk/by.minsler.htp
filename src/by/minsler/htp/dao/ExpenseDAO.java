package by.minsler.htp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import by.minsler.htp.beans.Expense;

public interface ExpenseDAO {

	ArrayList<Expense> getExpenses() throws SQLException;

	Expense getExpense(int num) throws SQLException;

	int addExpense(Expense expense) throws SQLException;

	int delExpense(int num) throws SQLException;

	int updateExpense(int num, Expense expense) throws SQLException;

}
