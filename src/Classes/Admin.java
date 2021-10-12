package Classes;

import java.util.HashMap;

public class Admin extends Person {

    public Admin(String name, String email, String address, char gender) {
        super(name, email, address, gender);
    }

    public void deposit(int userId, double amount, HashMap<Integer, User> users) {
        User user = Utils.getUser(userId, users);
        user.deposit(amount);
    }

    public void withdraw(int userId, double amount, HashMap<Integer, User> users) {
        User user = Utils.getUser(userId, users);
        user.withdraw(amount);
    }

    public void editUser(int userId, String changeType, String changeValue, HashMap<Integer, User> users) {
        User user = Utils.getUser(userId, users);
        switch (changeType) {
            case "name":
                user.setName(changeValue);
            case "email":
                user.setEmail(changeValue);
            case "address":
                user.setAddress(changeValue);
        }
    }
}
