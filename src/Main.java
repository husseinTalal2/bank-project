import java.util.HashMap;

import Classes.Person;
import Classes.Transaction;
import Classes.User;

public class Main {
    public static void main(String[] args) {
        User p = new User("aikay aikay", "email", "ishdc", 'f');
        System.out.println(p.getName());
        System.out.println(p.getEmail());
        System.out.println(p.getAddress());
        p.deposit(5000);

        // p.getSendingTransactions();
        HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();

        Transaction t = new Transaction(p.getId(), 156, 4000);
        Transaction t2 = new Transaction(p.getId(), 456, 500);

        System.out.println(t.getDate());
        p.addSendingTransactionId(t.getId());
        p.addSendingTransactionId(t2.getId());
        transactions.put(t.getId(), t);
        transactions.put(t2.getId(), t2);

        System.out.println(p.getSendingTransactions(transactions));
    }
}