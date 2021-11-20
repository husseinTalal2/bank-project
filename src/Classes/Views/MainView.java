package Classes.Views;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;
import Classes.Controller.ClientServerController;

public class MainView {
    
    
    public static void start() {
        ArrayList<User> users = Data.getUsers();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        Admin admin = new Admin("admin aikay", "email", "address", 'f');

        boolean isFinished = true;
        System.out.println("welcome to the management system!");
        try {
            while (isFinished) {
                Scanner input = new Scanner(System.in);

                System.out.println("-------------------------");
                System.out.println("choose the mode:");
                System.out.println("1-user");
                System.out.println("2-admin");
                System.out.println("3-exit");
                System.out.println("-------------------------");
                int choose = input.nextInt();
                switch (choose) {
                case 1:
                    UserModel.start(transactions, users);

                case 2:
                    AdminView.start(users, admin);
                case 3:
                    isFinished = false;
                }
                input.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
