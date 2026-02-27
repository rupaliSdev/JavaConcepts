package LLD_Design.problems.splitwise.models;

public class Transaction {
    private final User from;
    private final User to;
    private final double amount;

    public Transaction(User to, User from, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return from.getName() + " pays " +
                to.getName() + " : " + amount;
    }
}