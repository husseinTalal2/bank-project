package Classes.Controller.Server;

import java.io.*;
import java.util.ArrayList;

public class SaveData<T> {
    String path ;
//    T obj ;

    public SaveData(String path){
        this.path=path;
    }


    @SuppressWarnings("unchecked")
    public ArrayList<T> openList() {
        ArrayList<T> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream get = new ObjectInputStream(file);
            list = (ArrayList<T>)get.readObject();

            file.close();
            get.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + path);
        } catch (IOException e) {
            System.out.println("Error initializing stream"+e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveListToFile(ArrayList<T> items){
        try{
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(items);
            o.close();
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found Exception. #SaveData*addMovie"+ path);
            return false;
        } catch (IOException e){
            System.out.println("Error initializing stream. #SaveData*addMovie"+ path);
            return false;
        }
        return true;
    }


    
}
