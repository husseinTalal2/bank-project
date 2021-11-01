package Classes.Views;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Transaction;
import Classes.User;

public class UserModel {

    public static void userDashboard(User user, ArrayList<Transaction> transactions, ArrayList<User> users) {
        System.out.println("-----------------");
        System.out.println("1- check account history");
        System.out.println("2- check account balance");
        System.out.println("3- withdraw");
        System.out.println("4- deposit");

        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        int amount;
        switch (choose) {
        case 1:
            user.getHistory(transactions, users);
            break;
        case 2:
            System.out.println("your account balance: " + user.getBalance());
            break;
        case 3:
            System.out.println("enter the amount to withdraw: ");
            amount = input.nextInt();
            user.withdraw(amount);
            System.out.println("your balance after withdraw: " + user.getBalance());
            break;
        case 4:
            System.out.println("enter the amount to deposit: ");
            amount = input.nextInt();
            user.deposit(amount);
            System.out.println("your balance after deposit: " + user.getBalance());
            break;
        }
        input.close();
    }

}
