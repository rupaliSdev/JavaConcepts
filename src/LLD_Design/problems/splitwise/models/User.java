package LLD_Design.problems.splitwise.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private  final String id;
    private String name;
    private String mobileNo;
    //
    private List<Expense> expenses;
//    1:M
    private List<Group> groups;

   private String password;

    private LocalDateTime createdAt;

    public User(String id, String name,String mobileNo, String password) {
        this.id = id;
        this.name = name;
        this.expenses = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object user) {
        if(this==user)return true;
        if (!(user instanceof User)) return false;
        User user1=(User)user;
        return user1.getId().equals(this.id);
    }
}

/*
* user table
* expense_payer user_id ,expense_id
* user_group   user_id ,group_id
*
*
*
* */