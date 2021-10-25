package Classes;

import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

public class Transaction implements Serializable{
    Random rand = new Random();
    int maxNumber = 999999;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    final int id = rand.nextInt(maxNumber) + 1;
    String date = dtf.format(now);
    int senderId, receiverId;
    double amount;

    public Transaction(int senderId, int receiverId, double amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    };

    public int getId() {
        return this.id;
    }

    public int getSenderId() {
        return this.senderId;
    }

    public int getReceiverId() {
        return this.receiverId;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }
}
