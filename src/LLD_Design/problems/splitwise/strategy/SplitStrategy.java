package LLD_Design.problems.splitwise.strategy;

import LLD_Design.problems.splitwise.models.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SplitStrategy {

    Map<User ,Double> calculateSplit(double totalAmount,
                                     Set<User> users,
                                     Map<User,Double>inputData);
}