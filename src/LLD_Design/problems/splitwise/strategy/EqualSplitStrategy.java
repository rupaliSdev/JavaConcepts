package LLD_Design.problems.splitwise.strategy;

import LLD_Design.problems.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public Map<User, Double> calculateSplit(double totalAmount, Set<User> users, Map<User, Double> inputData) {
        Map<User, Double> result = new HashMap<>();
        double share = totalAmount/users.size();
        for (User user:users ){
            result.put(user,share);
        }
        return result;
    }
}
