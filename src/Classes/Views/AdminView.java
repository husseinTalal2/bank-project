package Classes.Views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Admin;
import Classes.User;
import Classes.Utils;

public class AdminView {

    public static void start(ArrayList<User> users, Admin admin) {
        try {
            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("--------------------------");
            System.out.println("choose what you want to do:");
            System.out.println("1- withdraw from user");
            System.out.println("2- deposit for user");
            System.out.println("3- edit user data");
            int choose = input.nextInt();
            String email, changeType, newValue;
            Double amount;
            switch (choose) {
            case 1:
                System.out.println("enter user email:");
                email = reader.readLine();
                System.out.println("enter the amount:");
                amount = input.nextDouble();
                AdminView.withdrawFromUser(admin, email, amount, users);
                break;
            case 2:
                System.out.println("enter user email:");
                email = reader.readLine();
                System.out.println("enter the amount:");
                amount = input.nextDouble();
                AdminView.depositForUser(admin, email, amount, users);
                break;
            case 3:
                System.out.println("enter user email:");
                email = reader.readLine();
                System.out.println("enter the type of change:");
                changeType = reader.readLine();
                System.out.println("enter the new value:");
                newValue = reader.readLine();
                AdminView.editUser(admin, email, changeType, newValue, users);
                System.out.println("data changed successfully");
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

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

    public static void editUser(Admin admin, String userEmail, String changeType, String changeValue,
            ArrayList<User> users) {
        User user = Utils.getUserByEmail(userEmail, users);
        admin.editUser(user.getId(), changeType, changeValue, users);
        System.out.println("user data changed successfully");

    }
}
