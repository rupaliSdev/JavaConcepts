package LLD_Design.problems.splitwise;

import LLD_Design.problems.splitwise.models.*;
import LLD_Design.problems.splitwise.services.BalanceService;
import LLD_Design.problems.splitwise.services.ExpenseService;
import LLD_Design.problems.splitwise.services.SettleMentService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SplitwiseApplication {

    List<Group> groups;

    ExpenseService expenseService;
    BalanceService balanceService;
    SettleMentService settleMentService;

    public SplitwiseApplication() {
        this.groups = groups;
        this.expenseService = new ExpenseService();
        this.balanceService = new BalanceService();
        this.settleMentService = new SettleMentService();
    }

    public Group createGroup(String groupId,String groupName,User createdBy){
        return new Group(groupId,groupName,createdBy);
    }

    public User createUser(String id,String name,String mobile,String pwd){
        return new User(id, name, mobile, pwd);
    }

    public void addExpense(String id, String desc, User createdBy, Group group, int amount, Map<User, Double> paid, SplitType splitType, Set<User> members, Map<User, Double> input) {
        expenseService.createExpense(id,
                desc,createdBy,group,amount,paid, splitType,
                members,input);
    }

    public void printNetBalance( Group group) {
        Map<User,Double> splitMap=balanceService.calculateNetBalances(group.getExpenses());
        for (Map.Entry<User,Double> entry: splitMap.entrySet()){

            System.out.println(entry.getKey().getName()+" - "+ entry.getValue());

        }
    }

    public void printTransactions(Group group) {
        List<Transaction> transactions= settleMentService.settle(group.getExpenses());
        System.out.println(transactions);
    }
}
