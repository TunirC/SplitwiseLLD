package SplitModels;

import Entities.User;

public class ExactExpenseSplit extends UserExpenseSplit {
    private double amountPerHead;

    public ExactExpenseSplit(User user, double amountPerHead) {
        super(user, 0);
        this.amountPerHead = amountPerHead;
    }

    public double getAmountPerHead() {
        return amountPerHead;
    }

    public void setAmountPerHead(double amountPerHead) {
        this.amountPerHead = amountPerHead;
    }
}
