package Expenses.Factory;

import Entities.User;
import Expenses.ExpenseModels.EqualExpense;
import Expenses.ExpenseModels.ExactExpense;
import Expenses.ExpenseModels.Expense;
import Enum.ExpenseSplitType;
import Expenses.ExpenseModels.PercentageExpense;
import SplitModels.EqualExpenseSplit;
import SplitModels.ExactExpenseSplit;
import SplitModels.PercentageExpenseSplit;
import SplitModels.UserExpenseSplit;

import java.util.List;

public class ExpenseFactory {
    public Expense createExpense(ExpenseSplitType splitType, double totalAmount, User paidBy, List<UserExpenseSplit> userExpenseSplits) {
        return switch (splitType) {
            case EQUAL -> {
                int totalUsers = userExpenseSplits.size();
                double amountTobePaidPerUser = totalAmount / totalUsers;
                userExpenseSplits.forEach(splits -> splits.setAmount(amountTobePaidPerUser));
                yield new EqualExpense(totalAmount, paidBy, splitType, userExpenseSplits);
            }
            case PERCENTAGE -> {
                userExpenseSplits
                        .forEach(split -> {
                            double percentage = ((PercentageExpenseSplit) split).getPercentage();
                            split.setAmount((totalAmount * percentage)/100);
                        });
                yield new PercentageExpense(totalAmount, paidBy, splitType, userExpenseSplits);
            }
            case EXACT -> {
                yield new ExactExpense(totalAmount, paidBy, splitType, userExpenseSplits);
            }
        };
    }
}
