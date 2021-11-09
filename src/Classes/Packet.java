package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Packet implements Serializable {
    private ArrayList item;
    private int message;

    public Packet(int message) {
        this.message = message;
    }

    public ArrayList getItem() {
        return item;
    }

    public void setItem(ArrayList item) {
        this.item = item;
    }

    public int getMessage() {
        return message;
    }

}
