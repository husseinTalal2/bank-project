package Classes;

import java.util.ArrayList;

import Classes.Controller.ClientServerController;

public class Data {

    public static ArrayList<User> getUsers() {
        Packet packet = new Packet(1);

        ClientServerController<User> clientServerController = new ClientServerController<>();
        try {
            return clientServerController.get(packet).getItem();
        } catch (NullPointerException e) {
            System.out.println("failed " + e);
            return null;
        }
    }

    public static boolean setUsers() {
        Packet packet = new Packet(2);

        ClientServerController<User> clientServerController = new ClientServerController<>();
        try {
            return clientServerController.get(packet).getMessage() == 1 ? true : false;
        } catch (NullPointerException e) {
            System.out.println("failed " + e);
            return false;
        }
    }

    public static ArrayList<Transaction> getTransactions() {
        Packet packet = new Packet(3);

        ClientServerController<Transaction> clientServerController = new ClientServerController<>();
        try {
            return clientServerController.get(packet).getItem();
        } catch (NullPointerException e) {
            System.out.println("failed " + e);
            return null;
        }
    }

    public static boolean setTransactions() {
        Packet packet = new Packet(4);

        ClientServerController<Transaction> clientServerController = new ClientServerController<>();
        try {
            return clientServerController.get(packet).getMessage() == 1 ? true : false;
        } catch (NullPointerException e) {
            System.out.println("failed " + e);
            return false;
        }
    }

}
