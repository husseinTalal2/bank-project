package Classes.Views;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import Classes.*;
import Classes.Controller.ClientServerController;

public class MainView {
    static ArrayList<User> users = new ArrayList<User>();

    public static boolean fetchAndSetUser() {
        Packet packet = new Packet(1);
        ClientServerController<User> clientServerController = new ClientServerController<>();
        try {
            users = clientServerController.get(packet).getItem();
        } catch (NullPointerException e) {
            System.out.println("fetchANdSetUser failed " + e);
            return false;
        }
        return true;

    }

    public static void start() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        // User p = new User("aikay aikay", "email", "pass", "ishdc", 'f');
        // users.add(p);
        // User p2 = new User("naikay naikay", "email", "pass", "ishdc", 'f');

        // users.add(p2);
        // Packet packet = new Packet(2);
        // packet.setItem(users);
        // ClientServerController<User> clientServerController = new
        // ClientServerController<>();
        // if (clientServerController.post(packet)) {
        // System.out.println("Post Succeed");
        // } else {
        // System.out.println("Not SUcce");
        // }

        if (fetchAndSetUser()) {
            System.out.println("get Succeed");
        } else {
            System.out.println("get failed");
        }

        Admin admin = new Admin("admin aikay", "email", "address", 'f');

        // Transaction t = new Transaction(p.getId(), p2.getId(), 4000);
        // Transaction t2 = new Transaction(p2.getId(), p.getId(), 500);

        // p.addSendingTransactionId(t.getId());
        // p.addReceivingTransactionId(t2.getId());
        // p2.addSendingTransactionId(t2.getId());
        // transactions.add(t);
        // transactions.add(t2);
        // try {
        // FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
        // ObjectOutputStream objectOutputStream = new
        // ObjectOutputStream(fileOutputStream);

        // objectOutputStream.writeObject(users);
        // objectOutputStream.close();
        // objectOutputStream.flush();
        // fileOutputStream.close();

        // FileInputStream fis = new FileInputStream("users.txt");
        // ObjectInputStream ois = new ObjectInputStream(fis);
        // ArrayList<User> result;
        // result = (ArrayList<User>) ois.readObject();

        // ois.close();

        // System.out.println(result.get(0).getName());
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        // e.printStackTrace();
        // }
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
                // isFinished = false;
                // input.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
