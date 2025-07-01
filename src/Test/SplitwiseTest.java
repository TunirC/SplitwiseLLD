package Test;

import Entities.User;
import Service.SplitwiseService;
import SplitModels.EqualExpenseSplit;
import SplitModels.UserExpenseSplit;
import Enum.ExpenseSplitType;

import java.util.Arrays;
import java.util.List;

public class SplitwiseTest {
    public static void main(String[] args) {
        SplitwiseService splitwise = SplitwiseService.getInstance();

        // Add users
        User user1 = new User("u1", "Alice", "123", "alice@test.com");
        User user2 = new User("u2", "Bob", "456", "bob@test.com");
        User user3 = new User("u3", "Charlie", "789", "charlie@test.com");

        splitwise.addUser(user1);
        splitwise.addUser(user2);
        splitwise.addUser(user3);

        // Create expense - Alice paid 300 equally for Alice, Bob, Charlie
        List<UserExpenseSplit> splits1 = Arrays.asList(
                new EqualExpenseSplit(user1, 0),
                new EqualExpenseSplit(user2, 0),
                new EqualExpenseSplit(user3, 0)
        );

        splitwise.addBalanceSheet(user1, ExpenseSplitType.EQUAL, 300.0, user1, splits1);

        System.out.println("\n--- All Balances ---");
        splitwise.getAllBalance();

        System.out.println("\n--- Balance for Bob ---");
        splitwise.getBalancePerUser(user2);

        System.out.println("\n--- Settling Bob's balances ---");
        splitwise.settleUp(user2);

        System.out.println("\n--- All Balances After Bob Settles ---");
        splitwise.getAllBalance();
    }
}
