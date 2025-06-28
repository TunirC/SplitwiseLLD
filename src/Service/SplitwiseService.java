package Service;

import Enum.ExpenseSplitType;
import Entities.User;
import Expenses.ExpenseModels.Expense;
import Expenses.Factory.ExpenseFactory;
import SplitModels.UserExpenseSplit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {
    private static SplitwiseService instance;

    private final Map<String, User> users;
    private final Map<String, Map<String, Double>> balanceSheet;
    private final ExpenseFactory factory;

    private SplitwiseService() {
        if (instance != null) {
            throw new RuntimeException("instance already exists");
        }

        this.users = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.factory = new ExpenseFactory();
    }

    public static SplitwiseService getInstance() {
        SplitwiseService localRef = instance;
        if (localRef == null) {
            synchronized (SplitwiseService.class) {
                if (localRef == null) {
                    instance = localRef = new SplitwiseService();
                }
            }
        }
        return instance;
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUserId())) {
            throw new RuntimeException("user already exists");
        }
        users.put(user.getUserId(), user);
    }

    public void addBalanceSheet(User user, ExpenseSplitType splitType, double amount, User paidBy, List<UserExpenseSplit> userExpenseSplitList) {
        Expense expense = factory.createExpense(splitType, amount, paidBy, userExpenseSplitList);

        expense.getUserExpenseSplits()
                        .forEach(splits -> {
                            if (!paidBy.getUserName().equals(splits.getUser().getUserName())) {
                                Map<String, Double> userBalanceMap = balanceSheet.getOrDefault(paidBy.getUserName(), new HashMap<>());
                                userBalanceMap.put(splits.getUser().getUserName(), userBalanceMap.getOrDefault(splits.getUser().getUserName(), 0D) + splits.getAmount());
                                balanceSheet.put(paidBy.getUserName(), userBalanceMap);

                                Map<String, Double> userMap = balanceSheet.getOrDefault(splits.getUser().getUserName(), new HashMap<>());
                                userMap.put(paidBy.getUserName(), userMap.getOrDefault(paidBy.getUserName(), 0.0) - splits.getAmount());
                                balanceSheet.put(splits.getUser().getUserName(), userMap);
                            }
                        });
    }

    public void getBalancePerUser(User user) {
        if (balanceSheet.get(user.getUserName()) == null || balanceSheet.get(user.getUserName()).isEmpty()) {
            System.out.println("User: "+user.getUserName()+" -- No Dues");
            return;
        }

        balanceSheet.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(user.getUserName()))
                .map(Map.Entry::getValue)
                .flatMap(userBalance -> userBalance.entrySet().stream())
                .forEach(userBalance -> {
                    if(userBalance.getValue() > 0) {
                        System.out.println("User: "+user.getUserName()+" => "+userBalance.getValue()+" balance owed by user: "+userBalance.getKey());
                    } else if (userBalance.getValue() < 0) {
                        System.out.println("User: "+user.getUserName()+" => "+userBalance.getValue()+" balance owed to user: "+userBalance.getKey());
                    }
                });
    }

    public void getAllBalance() {
        balanceSheet.entrySet()
                .forEach(user -> {
                    String username = user.getKey();
                    user.getValue().entrySet().stream().forEach(userEntries -> {
                        double amount = userEntries.getValue();
                        if (amount > 0) {
                            System.out.println("User: "+username+" => "+ amount + " balance owed by user: "+userEntries.getKey());
                        } else if (amount < 0) {
                            System.out.println("User: "+username+" => "+ amount + " balance owed to user: "+userEntries.getKey());
                        }
                    });
                });
    }
}
