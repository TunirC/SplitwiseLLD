package SplitModels;

import Entities.User;

public class EqualExpenseSplit extends UserExpenseSplit {
    private double amountPerHead;

    public EqualExpenseSplit(User user, double totalAmount) {
        super(user, totalAmount);
    }

    public double getAmountPerHead() {
        return amountPerHead;
    }

    public void setAmountPerHead(double amountPerHead) {
        this.amountPerHead = amountPerHead;
    }
}
