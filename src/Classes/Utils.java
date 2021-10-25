package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Utils {
    public static User getUser(int id, ArrayList<User> users) {
        User matchedUser = users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return matchedUser;
    }

    public static String getUserName(int id, ArrayList<User> users) {
        User user = Utils.getUser(id, users);
        return user.getName();
    }

    public static Transaction getTransaction(int id, ArrayList<Transaction> transactions) {
        Transaction matchedTransaction = transactions.stream().filter(transaction -> transaction.getId() == id).findAny().orElse(null);
        return matchedTransaction;
        
    }
    public static int getTransactionIndex(int id, ArrayList<Transaction> transactions) {
        Transaction t = Utils.getTransaction(id, transactions);
        return transactions.indexOf(t);
        
    }

    public static User getUserByEmail(String email, ArrayList<User> users) {
        User matchedUser = users.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
        if(matchedUser == null){
            return null;
        }else{
            return matchedUser;
        }
    }
    public static User userLogin(String email, String password, ArrayList<User> users) {
        User user = Utils.getUserByEmail(email, users);
        if(user == null){
            return null;
        }
        else if(user.getPassword().equals(password)){
            return user;
        }else{
            return null;
        }
    }


}
