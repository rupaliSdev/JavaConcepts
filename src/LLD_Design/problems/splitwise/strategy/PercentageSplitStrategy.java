package LLD_Design.problems.splitwise.strategy;


import LLD_Design.problems.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PercentageSplitStrategy implements SplitStrategy{


    @Override
    public Map<User, Double> calculateSplit(double totalAmount, Set<User> users, Map<User, Double> percentageMap) {
       double sum = percentageMap.values()
               .stream().mapToDouble(Double::doubleValue).sum();
       if(Math.abs(sum-100)>0.01){
           throw  new RuntimeException("Percenatge must total 100 ");
       }
        Map<User, Double> result = new HashMap<>();

       for(User user: users){
           double percent = percentageMap.get(user);
           result.put(user,totalAmount * percent/100);
       }
       return result;
    }

}
