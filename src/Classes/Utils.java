package Classes;

import java.util.HashMap;

class Utils {
    public static User getUser(int id, HashMap<Integer, User> users) {
        return users.get(id);
    }
    public static String getUserName(int id, HashMap<Integer, User> users) {
        return users.get(id).getName();
    }
}
