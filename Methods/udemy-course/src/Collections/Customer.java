package Collections;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initial) {
        this.name = name;
        this.transactions = new ArrayList<>();
        transactions.add(initial);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        this.transactions.add(transaction);
    }
}
