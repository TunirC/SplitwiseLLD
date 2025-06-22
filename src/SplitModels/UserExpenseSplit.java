package SplitModels;

import Entities.User;

public class UserExpenseSplit {
    private User user;
    private double totalAmount;

    public UserExpenseSplit(User user, double totalAmount) {
        this.user = user;
        this.totalAmount = totalAmount;
    }
}
