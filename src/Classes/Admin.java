package Classes;

import java.util.HashMap;

public class Admin {
    public void deposit(int userId, double amount, HashMap<Integer, User> users) {
        User user = Utils.getUser(userId, users);
        user.deposit(amount);
    }

    public void withdraw(int userId, double amount, HashMap<Integer, User> users) {
        User user = Utils.getUser(userId, users);
        user.withdraw(amount);
    }

    public void editUser(int userId, String changeType, String changeValue) {
        switch (changeType) {
            
        }

    }
}
