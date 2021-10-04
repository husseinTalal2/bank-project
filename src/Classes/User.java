package Classes;

import java.util.ArrayList;

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

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("The amount of deposited money should be greater than zero!");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
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

    public ArrayList<Integer> getSendingTransactions() {
        return sendingTransactionIds; 
    }

    public ArrayList<Integer> getReceivingTransactions() {
        return receivingTransactionIds;
    }

    public void getHistory() {
        
    }
}
