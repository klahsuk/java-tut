package Collections;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }


    private Branch findBranch(String name){

        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }

        return null;
    }

    public boolean addBranch(String name){

        Branch customer = findBranch(name);
        if (customer == null){
            return branches.add(new Branch(name));
        }
        //pre existing branch
        else return false;
    }

    public boolean addCustomer(String branchName, String name, double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.newCustomer(name, transaction);
        }
        else return false;
    }

    public boolean addCustomerTransaction(String branchName, String name, double transaction){
        Branch branch = findBranch(branchName);
        if (branch == null){return false;}

        return branch.addCustomerTransaction(name, transaction);
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch = findBranch(branchName);

        if(branch == null){return false;}

        System.out.printf("Customer details for branch %s\n", branchName);
        var customers = branch.getCustomers();
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
            if(printTransactions){
                System.out.println("Transactions");
                var transactions = customers.get(i).getTransactions();
                for (int j = 0; j < transactions.size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                }
            }

        }

        return true;
    }
}