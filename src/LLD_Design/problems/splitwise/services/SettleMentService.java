package LLD_Design.problems.splitwise.services;

import LLD_Design.problems.splitwise.models.Expense;
import LLD_Design.problems.splitwise.models.Transaction;
import LLD_Design.problems.splitwise.models.User;

import java.util.Comparator;
import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

public class SettleMentService {

    public List<Transaction> settle(List<Expense> expenses){

        BalanceService balanceService = new BalanceService();
        Map<User,Double> balances =balanceService.calculateNetBalances(expenses);

        PriorityQueue<Map.Entry<User, Double>> creditors =
                new PriorityQueue<>(
                        (a, b) -> Double.compare(b.getValue(), a.getValue()));

        PriorityQueue<Map.Entry<User, Double>> debtors =
                new PriorityQueue<>(
                        Comparator.comparingDouble(Map.Entry::getValue));


        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            if (entry.getValue() > 0) creditors.add(entry);
            else if (entry.getValue() < 0) debtors.add(entry);
        }

        List<Transaction> transactions = new ArrayList<>();

        while (!creditors.isEmpty() && !debtors.isEmpty()){

            Map.Entry<User,Double> creditor = creditors.poll();
            Map.Entry<User,Double> debtor = debtors.poll();

            double settleAmount = Math.min(creditor.getValue(),-debtor.getValue());

            transactions.add(new Transaction(creditor.getKey(),debtor.getKey(),settleAmount));

            double newCred = creditor.getValue()-settleAmount;
            double newDebt = debtor.getValue()+settleAmount;


            if(newCred>0){
                creditors.add(new AbstractMap.SimpleEntry<>(creditor.getKey(),newCred));
            }
            if(newDebt<0){
                debtors.add(new AbstractMap.SimpleEntry<>(debtor.getKey(),newDebt));
            }



        }
        return transactions;


    }
}
