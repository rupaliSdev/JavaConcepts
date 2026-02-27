package LLD_Design.problems.splitwise;


import LLD_Design.problems.splitwise.models.*;
import LLD_Design.problems.splitwise.services.BalanceService;
import LLD_Design.problems.splitwise.services.SettleMentService;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        SplitwiseApplication sn= new SplitwiseApplication();
        // 1️⃣ Create Users
        User rupali = sn.createUser("U1", "Rupali", "9999999991", "pass");
        User ankit = sn.createUser("U2", "Ankit", "9999999992", "pass");
        User neha = sn.createUser("U3", "Neha", "9999999993", "pass");

        //create Group
        Group group= sn.createGroup("grp1","Home",rupali);
        group.addUser(rupali);
        group.addUser(ankit);
        group.addUser(neha);


        BalanceService balanceService= new BalanceService();
        SettleMentService settleMentService = new SettleMentService();

       sn.addExpense("e1",
               "trip",rupali,group,500,Map.of(rupali,500.0), SplitType.EQUAL,
               group.getMembers(),null);


        sn.addExpense("e1",
                "trip",rupali,group,500,Map.of(rupali,500.0), SplitType.EQUAL,
                group.getMembers(),null);


        sn.addExpense("e2",
                "food",rupali,group,200,Map.of(ankit,200.0), SplitType.EQUAL,
               group.getMembers(),null);


        sn.printNetBalance(group);

        sn.printTransactions(group);


    }
}
