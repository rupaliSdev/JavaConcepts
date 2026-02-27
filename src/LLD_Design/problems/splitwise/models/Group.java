package LLD_Design.problems.splitwise.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    //1:M
    String groupId;
    String groupName;
    LocalDateTime createdAt;
    User createdBy;

    Set<User> members;
    List<Expense> expenses;

    public Group(String groupId, String groupName,  User createdBy) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.createdAt = LocalDateTime.now();
        this.createdBy = createdBy;
        this.members= new HashSet<>();
        this.expenses= new ArrayList<>();
        members.add(createdBy);
    }

    public void addMember(User member,User requestor){
        if(!createdBy.equals(requestor)){
            throw new RuntimeException("Only Creator can add members");
        }
        members.add(member);
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public Set<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addUser(User user) {
        this.getMembers().add(user);
    }
}
