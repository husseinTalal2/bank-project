import Classes.Person;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("aikay aikay", "email", "ishdc", 'f');
        System.out.println(p.getName());
        System.out.println(p.getEmail());
        System.out.println(p.getAddress());
    }
}