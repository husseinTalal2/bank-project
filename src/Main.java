import java.util.HashMap;

import Classes.Person;
import Classes.Transaction;
import Classes.User;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        User p = new User("aikay aikay", "email", "ishdc", 'f');
        users.put(p.getId(), p);
        User p2 = new User("aikay aikay", "email", "ishdc", 'f');
        users.put(p2.getId(), p2);

        // System.out.println(p.getName());
        // System.out.println(p.getEmail());
        // System.out.println(p.getAddress());
        p.deposit(5000);
        p2.deposit(5000);

        // p.getSendingTransactions();

        Transaction t = new Transaction(p.getId(), 156, 4000);
        Transaction t2 = new Transaction(p2.getId(), p.getId(), 500);

        // System.out.println(t.getDate());
        p.addSendingTransactionId(t.getId());
        p.addReceivingTransactionId(t2.getId());
        p2.addSendingTransactionId(t2.getId());
        transactions.put(t.getId(), t);
        transactions.put(t2.getId(), t2);
        p.getHistory(transactions, users);
        System.out.println();
        p2.getHistory(transactions, users);

    }
}