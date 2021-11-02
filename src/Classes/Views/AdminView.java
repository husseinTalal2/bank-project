package Classes.Views;

import java.util.ArrayList;

import Classes.Admin;
import Classes.User;
import Classes.Utils;

public class AdminView {
    public static void withdrawFromUser(Admin admin, String userEmail, double amount, ArrayList<User> users) {
        User user = Utils.getUserByEmail(userEmail, users);
        admin.withdraw(user.getId(), amount, users);
        System.out.println(user.getName() + " balance after withdraw is " + user.getBalance());

    }
    public static void depositForUser(Admin admin, String userEmail, double amount, ArrayList<User> users) {
        User user = Utils.getUserByEmail(userEmail, users);
        admin.deposit(user.getId(), amount, users);
        System.out.println(user.getName() + " balance after deposit is " + user.getBalance());

    }
    public static void editUser(Admin admin, String userEmail, String changeType, String changeValue, ArrayList<User> users) {
        User user = Utils.getUserByEmail(userEmail, users);
        admin.editUser(user.getId(), changeType, changeValue, users);
        System.out.println("user data changed successfully");

    }
}
