package LLD_Design.problems.splitwise.models;

import java.time.LocalDateTime;
import java.util.Map;

public class Expense {

    String expenseId;
    String description;
    double totalAmount;

    LocalDateTime createdAt;
//    1:M
    Map<User,Double> paidAmounts;
    //1:M
    Map<User, Double> expenseSplit;

    Group group;

    public Expense(String expenseId, String description, double totalAmount, LocalDateTime createdAt, Map<User, Double> paidAmounts, Map<User, Double> expenseSplit, Map<User, Double> owedAmounts,Group group) {
        this.expenseId = expenseId;
        this.description = description;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.paidAmounts = paidAmounts;
        this.expenseSplit = expenseSplit;
        this.group=group;
        validate();
    }
    private void validate() {
        double paid = paidAmounts.values().stream().mapToDouble(Double::doubleValue).sum();
        double owed = expenseSplit.values().stream().mapToDouble(Double::doubleValue).sum();

        if (Math.abs(paid - owed) > 0.01)
            throw new RuntimeException("Paid and owed mismatch");
    }

    public Map<User, Double> getPaidAmounts() {
        return paidAmounts;
    }

    public Map<User, Double> getExpenseSplit() {
        return expenseSplit;
    }
}
/*
*
*
*
* */