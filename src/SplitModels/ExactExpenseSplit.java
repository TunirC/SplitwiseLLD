package SplitModels;

import Entities.User;

public class ExactExpenseSplit extends UserExpenseSplit {
    private double amountPerHead;

    public ExactExpenseSplit(User user, double totalAmount) {
        super(user, totalAmount);
    }

    public double getAmountPerHead() {
        return amountPerHead;
    }

    public void setAmountPerHead(double amountPerHead) {
        this.amountPerHead = amountPerHead;
    }
}
