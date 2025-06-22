package SplitModels;

import Entities.User;

public class PercentageExpenseSplit extends UserExpenseSplit {
    private double amountPerHead;

    public PercentageExpenseSplit(User user, double totalAmount) {
        super(user, totalAmount);
    }

    public double getAmountPerHead() {
        return amountPerHead;
    }

    public void setAmountPerHead(double amountPerHead) {
        this.amountPerHead = amountPerHead;
    }


}
