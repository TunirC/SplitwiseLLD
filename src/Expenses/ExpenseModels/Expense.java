package Expenses.ExpenseModels;

import Entities.User;
import Enum.ExpenseSplitType;
import SplitModels.UserExpenseSplit;

import java.util.List;

public abstract class Expense {
    private double amount;
    private User paidBy;
    private ExpenseSplitType splitType;
    private List<UserExpenseSplit> userExpenseSplits;

    public Expense(double amount, User paidBy, ExpenseSplitType splitType, List<UserExpenseSplit> userExpenseSplits) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.userExpenseSplits = userExpenseSplits;
    }

    public abstract boolean validate();

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<UserExpenseSplit> getUserExpenseSplits() {
        return userExpenseSplits;
    }
}
