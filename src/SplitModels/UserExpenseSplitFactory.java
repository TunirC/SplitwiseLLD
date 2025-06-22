package SplitModels;

import Entities.User;
import Enum.ExpenseSplitType;

public class UserExpenseSplitFactory {
    public UserExpenseSplit createUserExpenseSplit(User user, double amount, ExpenseSplitType expenseSplitType) {
        return switch (expenseSplitType) {
            case EXACT -> new ExactExpenseSplit(user, amount);
            case PERCENTAGE -> new PercentageExpenseSplit(user, amount);
            case EQUAL -> new EqualExpenseSplit(user, amount);
        };
    }
}
