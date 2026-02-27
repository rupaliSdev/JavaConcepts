package LLD_Design.problems.splitwise.services;

import LLD_Design.problems.splitwise.models.Expense;
import LLD_Design.problems.splitwise.models.User;

import java.util.*;

public class BalanceService {

    public Map<User, Double> calculateNetBalances(List<Expense> expenses) {

        Map<User, Double> balanceMap = new HashMap<>();

        for (Expense expense : expenses) {

            for (Map.Entry<User, Double> entry :
                    expense.getPaidAmounts().entrySet()) {

                balanceMap.put(entry.getKey(),
                        balanceMap.getOrDefault(entry.getKey(), 0.0)
                                + entry.getValue());
            }

            for (Map.Entry<User, Double> entry :
                    expense.getExpenseSplit().entrySet()) {

                balanceMap.put(entry.getKey(),
                        balanceMap.getOrDefault(entry.getKey(), 0.0)
                                - entry.getValue());
            }
        }

        return balanceMap;
    }
}