import Classes.Controller.ClientServerConnection;
import Classes.Views.MainView;

public class Main {
    public static void main(String[] args) {
        ClientServerConnection.startConnection();
        MainView.start();
    }
}