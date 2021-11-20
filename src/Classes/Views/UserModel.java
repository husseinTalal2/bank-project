package Classes.Views;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Transaction;
import Classes.User;
import Classes.Utils;

public class UserModel {

    public static void start(ArrayList<Transaction> transactions, ArrayList<User> users) {
        try {
            Scanner input = new Scanner(System.in);
            String name, email, password, address, changeType, newValue;
            char gender;
            Double amount;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.close();
            objectOutputStream.flush();
            System.out.println("-------------------------");
            System.out.println("1- already have an account:");
            System.out.println("2- signup:");
            System.out.println("-------------------------");
            int choose = input.nextInt();
            User u;
            switch (choose) {
            case 1:
                System.out.println("Enter  your email:");
                email = reader.readLine();
                System.out.println("Enter  your password:");
                password = reader.readLine();
                users.get(0);
                u = Utils.userLogin(email, password, users);

                UserModel.userDashboard(u, transactions, users);
                break;
            case 2:
                System.out.println("enter your information:");
                System.out.println("enter your name:");
                name = reader.readLine();
                System.out.println("enter your email:");
                email = reader.readLine();
                System.out.println("enter your password:");
                password = reader.readLine();
                System.out.println("enter your address:");
                address = reader.readLine();
                System.out.println("enter your gender: (f or m)");
                gender = input.next().charAt(0);
                u = Utils.userSignUp(name, email, password, address, gender);
                users.add(u);
                UserModel.userDashboard(u, transactions, users);
                break;
            default:
                System.out.println("choose a number");
                break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

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
