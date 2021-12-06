import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User("Jorge", 1);
        BankAccount bankAccount = new BankAccount(user);

        Menu menu = new Menu();
        menu.setUser(user);
        menu.setBankAccount(bankAccount);



        menu.showMenu();


    }
}
