package Entities;

import Enum.ExpenseSplitType;
import SplitModels.UserExpenseSplit;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private ExpenseSplitType splitType;
    private List<UserExpenseSplit> userExpenseSplits;

    public abstract void validate();
}
