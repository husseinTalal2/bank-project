package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends Person {
    double balance = 0;
    ArrayList<Integer> sendingTransactionIds = new ArrayList<>();
    ArrayList<Integer> receivingTransactionIds = new ArrayList<>();

    public User(String name, String email, String address, char gender) {
        super(name, email, address, gender);
    }

    public double getBalance() {
        return balance;
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

    public ArrayList<Transaction> getSendingTransactions(HashMap<Integer, Transaction> transactions) {
        ArrayList<Transaction> sendingTransactions = new ArrayList<Transaction>();
        for (int i = 0; i < sendingTransactionIds.size(); i++) {
            sendingTransactions.add((Transaction) transactions.get(sendingTransactionIds.get(i)));
        }
        return sendingTransactions;
    }

    public ArrayList<Transaction> getReceivingTransactions(HashMap<Integer, Transaction> transactions) {
        ArrayList<Transaction> receivingTransactions = new ArrayList<Transaction>();
        for (int i = 0; i < receivingTransactionIds.size(); i++) {
            receivingTransactions.add((Transaction) transactions.get(receivingTransactionIds.get(i)));
        }
        return receivingTransactions;
    }

    // public Transaction[] getReceivingTransactions(HashMap Transactions) {
    // return ;
    // }

    public void getHistory(HashMap<Integer, Transaction> transactions, HashMap<Integer, User> users) {
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
