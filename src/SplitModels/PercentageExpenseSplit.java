package SplitModels;

import Entities.User;

public class PercentageExpenseSplit extends UserExpenseSplit {
    private double percentage;

    public PercentageExpenseSplit(User user, double percentage) {
        super(user, 0);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
