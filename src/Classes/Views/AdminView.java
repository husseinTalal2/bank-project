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
}
