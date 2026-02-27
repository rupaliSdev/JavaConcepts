package LLD_Design.problems.splitwise.models;

public class ExpenseSplit {

    Expense expense;
    User userToBeSplitted;

    SplitType splitType;
    public ExpenseSplit(Expense expense, User userToBeSplitted) {
        this.expense = expense;
        this.userToBeSplitted = userToBeSplitted;
    }
}

