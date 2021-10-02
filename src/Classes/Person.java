package Classes;

import java.util.Random;

public class Person {
    int id;
	String name;
	String email;
	String address;
	char gender;

    public Person(String name, String email, String address, char gender) {
        Random rand = new Random();
        int maxNumber = 999999;

        this.id = rand.nextInt(maxNumber) + 1;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return this.address;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }
    


    
}