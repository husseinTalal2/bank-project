package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends Person implements Serializable{
    double balance = 0;
    String password;
    ArrayList<Integer> sendingTransactionIds = new ArrayList<>();
    ArrayList<Integer> receivingTransactionIds = new ArrayList<>();

    public User(String name, String email, String password, String address, char gender) {
        super(name, email, address, gender);
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }
    public String getPassword() {
        return password;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("The amount of deposited money should be greater than zero!");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if ((balance - amount) < 0) {
            System.out.println(
                    "The amount of withdrawn money is greater than the current balance, try again with a decent amount");
        } else {
            this.balance -= amount;
        }
    }

    public void addSendingTransactionId(int id) {
        sendingTransactionIds.add(id);
    }

    public void addReceivingTransactionId(int id) {
        receivingTransactionIds.add(id);
    }

    public ArrayList<Transaction> getSendingTransactions(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> sendingTransactions = new ArrayList<Transaction>();
        for (int i = 0; i < sendingTransactionIds.size(); i++) {
            sendingTransactions.add(Utils.getTransaction(sendingTransactionIds.get(i), transactions));
        }

        return sendingTransactions;
    }

    public ArrayList<Transaction> getReceivingTransactions(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> receivingTransactions = new ArrayList<Transaction>();
        for (int i = 0; i < receivingTransactionIds.size(); i++) {
            receivingTransactions.add(Utils.getTransaction(sendingTransactionIds.get(i), transactions));
        }
        return receivingTransactions;
    }

    // public Transaction[] getReceivingTransactions(HashMap Transactions) {
    // return ;
    // }

    public void getHistory(ArrayList<Transaction> transactions, ArrayList<User> users) {
        ArrayList<Transaction> receivingTransactions = getReceivingTransactions(transactions);
        ArrayList<Transaction> sendingTransactions = getSendingTransactions(transactions);

        System.out.println("sending transactions: \n");
        System.out.println("transaction no -- sender -- receiver -- amount -- date");
        for (int i = 0; i < sendingTransactions.size(); i++) {
            var transaction = sendingTransactions.get(i);
            System.out.println(transaction.getId() + " -- " + Utils.getUserName(transaction.getSenderId(), users)
                    + " -- " + Utils.getUserName(transaction.getReceiverId(), users) + " -- " + transaction.getAmount()
                    + " -- " + transaction.getDate());
        }

        System.out.println();

        System.out.println("receiving transactions: \n");
        System.out.println("transaction no -- sender -- receiver -- amount -- date");
        for (int i = 0; i < receivingTransactions.size(); i++) {
            var transaction = receivingTransactions.get(i);
            System.out.println(transaction.getId() + " -- " + Utils.getUserName(transaction.getSenderId(), users)
                    + " -- " + Utils.getUserName(transaction.getReceiverId(), users) + " -- " + transaction.getAmount()
                    + " -- " + transaction.getDate());
        }

    }
}
