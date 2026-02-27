package LLD_Design.problems.splitwise.services;

import LLD_Design.problems.splitwise.models.Expense;
import LLD_Design.problems.splitwise.models.Group;
import LLD_Design.problems.splitwise.models.SplitType;
import LLD_Design.problems.splitwise.models.User;
import LLD_Design.problems.splitwise.strategy.SplitStrategy;
import LLD_Design.problems.splitwise.strategy.SplitStrategyFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpenseService {

    public Expense createExpense(  String id,
                                     String description,
                                     User createdBy,
                                     Group group,
                                     double totalAmount,
                                     Map<User, Double> paidAmounts,
                                     SplitType splitType,
                                     Set<User> splitUsers,
                                     Map<User, Double> inputData){


        SplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);
        Map<User ,Double> owedAmounts = strategy.calculateSplit(totalAmount,splitUsers,inputData);
        Expense expense= new Expense(id,
                description,totalAmount, LocalDateTime.now(),
                paidAmounts,
                owedAmounts,owedAmounts,group);
        group.addExpense(expense);
        return expense;
    }




}
