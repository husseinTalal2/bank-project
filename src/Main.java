import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Classes.Admin;

import Classes.Transaction;
import Classes.User;
import Classes.Utils;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        ArrayList<User> users = new ArrayList<User>();

        User p = new User("aikay aikay", "email", "pass", "ishdc", 'f');
        users.add(p);
        User p2 = new User("naikay naikay", "email", "pass", "ishdc", 'f');
        users.add(p2);

        Admin admin = new Admin("admin aikay", "email", "address", 'f');
        admin.editUser(p.getId(), "name", "just aikay", users);

        p.deposit(5000);
        p2.deposit(5000);

        Transaction t = new Transaction(p.getId(), p2.getId(), 4000);
        Transaction t2 = new Transaction(p2.getId(), p.getId(), 500);

        // System.out.println(t.getDate());
        p.addSendingTransactionId(t.getId());
        p.addReceivingTransactionId(t2.getId());
        p2.addSendingTransactionId(t2.getId());
        transactions.add(t);
        transactions.add(t2);
        // p2.getHistory(transactions, users);
        // ListFile<ArrayList<Transaction>> data = new
        // ListFile<ArrayList<Transaction>>("users.ser");
        // data.open();
        // data.add(transactions);
        // System.out.println(data.obj);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            objectOutputStream.flush();
            fileOutputStream.close();

            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<User> result;
            result = (ArrayList<User>) ois.readObject();

            ois.close();

            System.out.println(result.get(0).getName());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        boolean isFinished = true;
        System.out.println("welcome to the management system!");
        while (isFinished) {
            String name, email, password, address;
            char gender;
            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("-------------------------");
            System.out.println("choose the mode:");
            System.out.println("1-user");
            System.out.println("2-admin");
            System.out.println("3-exit");
            System.out.println("-------------------------");
            int choose = input.nextInt();
            switch (choose) {
            case 1:
                FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.close();
                objectOutputStream.flush();
                System.out.println("-------------------------");
                System.out.println("1- already have an account:");
                System.out.println("2- signup:");
                System.out.println("-------------------------");
                choose = input.nextInt();
                switch (choose) {
                case 1:
                    System.out.println("Enter  your email:");
                    email = reader.readLine();
                    System.out.println("Enter  your password:");
                    password = reader.readLine();

                    Utils.userLogin(email, password, users);
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
                    users.add(Utils.userSignUp(name, email, password, address, gender));
                    // objectOutputStream.writeObject(users);
                    break;
                default:
                    System.out.println("choose a number");
                    break;
                }
                break;

            default:
                break;
            }
            isFinished = false;
        }
    }
}