import Classes.Person;
import Classes.User;

public class Main {
    public static void main(String[] args) {
        User p = new User("aikay aikay", "email", "ishdc", 'f');
        System.out.println(p.getName());
        System.out.println(p.getEmail());
        System.out.println(p.getAddress());
        p.deposit(5000);
        p.addSendingTransactionId(156);
        p.getSendingTransactions();
    }
}