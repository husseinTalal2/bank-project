package Classes.Controller.Server;

import java.io.*;
import java.net.Socket;
import java.util.*;
import Classes.User;

import Classes.Packet;
import Classes.Transaction;

public class PacketController extends Thread {
    private Socket socket;

    public PacketController(Socket socket) {
        this.socket = socket;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {

        try {
            System.out.println("Client Connected");
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            socket.setTcpNoDelay(true);
            Packet packet;

            while (true) {
                System.out.println("1");
                packet = (Packet) input.readObject();
                int packetMessage = packet.getMessage();
                System.out.println("Received Client input: " + packetMessage);
                if (packetMessage == 0) {
                    packet = new Packet(2);
                    break;
                } else {
                    packet = processPacket(packet);
                }
                System.out.println("Before OutputStream");
                outStream.writeObject(packet);
                outStream.flush();
            }
            outStream.writeObject(packet);
            outStream.close();
            input.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
        }
        System.out.println("Disconnected");

    }

    private Packet processPacket(Packet packet) {
        // Packet packet=null;
        int packetMessage = packet.getMessage();
        if (packetMessage == 1) {
            SaveData<User> userSaveData = new SaveData<>("src/data/users.txt");
            ArrayList<User> users = userSaveData.openList();
            if (users.isEmpty()) {
                packet = new Packet(0);
            } else {
                packet = new Packet(1);
                packet.setItem(users);
            }
        } else if (packetMessage == 2) {
            SaveData<User> userSaveData = new SaveData<>("src/data/users.txt");

            if (userSaveData.saveListToFile(packet.getItem())) {
                packet = new Packet(1);
            } else {
                packet = new Packet(0);

            }

        } else if (packetMessage == 3) {
            SaveData<Transaction> transactionsSaveData = new SaveData<>("src/data/transactions.txt");
            ArrayList<Transaction> transactions = transactionsSaveData.openList();
            if (transactions.isEmpty()) {
                packet = new Packet(0);
            } else {
                packet = new Packet(1);
                packet.setItem(transactions);
            }

        } else if (packetMessage == 4) {
            SaveData<Transaction> transactionsSaveData = new SaveData<>("src/data/transactions.txt");
            if (transactionsSaveData.saveListToFile(packet.getItem())) {
                packet = new Packet(1);
            } else {
                packet = new Packet(0);
            }
        } else {
            packet = new Packet(2);
        }
        return packet;
    }

}
