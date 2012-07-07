package by.minsler.dao;

import java.util.ArrayList;

import by.minsler.htp.beans.Expense;

public interface ExpenseDAO {

	ArrayList<Expense> getExpenses();

	Expense getExpense(int num);

	int addExpense(Expense expense);

	int delExpense(int num);

	int updateExpense(int num, Expense expense);

}
