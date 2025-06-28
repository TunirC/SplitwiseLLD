package Expenses.ExpenseModels;

import Entities.User;
import SplitModels.UserExpenseSplit;
import Enum.ExpenseSplitType;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(double amount, User paidBy, ExpenseSplitType splitType, List<UserExpenseSplit> userExpenseSplits) {
        super(amount, paidBy, splitType, userExpenseSplits);
    }

    @Override
    public boolean validate() {
        return getUserExpenseSplits().stream()
                .mapToDouble(UserExpenseSplit::getAmount)
                .sum() == getAmount();
    }
}
