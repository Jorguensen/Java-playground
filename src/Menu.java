import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private User user;
    private BankAccount bankAccount;


    public void setUser(User user) {
        this.user = user;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    public Menu showMenu() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome " + user.getName());
        System.out.println("Your id is: " + user.getId());
        System.out.println("\n");

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Previous Transaction");
        System.out.println("5. Exit Menu");


        System.out.println("Enter your option: ");
        int option = scanner.nextInt();

        do {

            switch (option) {
                case 1 -> {
                    System.out.println(" Balance = " + bankAccount.checkBalance());
                    System.out.println("\n");
                    return showMenu();

                }
                case 2 -> {
                    System.out.println("Enter the amount to deposit");
                    int amount = scanner.nextInt();
                    bankAccount.deposit(amount);
                    System.out.println("Current balance = " + bankAccount.checkBalance());
                    System.out.println("\n");
                    return showMenu();
                }
                case 3 -> {
                    System.out.println("Enter the amount to withdraw");
                    int amount2 = scanner.nextInt();
                    bankAccount.withdraw(amount2);
                    System.out.println("Current balance = " + bankAccount.checkBalance());
                    System.out.println("\n");
                    return showMenu();
                }
                case 4 -> {
                    System.out.println("The previous transaction was: ");
                    bankAccount.getPreviousTransactions();
                    System.out.println("\n");
                    return  showMenu();
                }
                case 5 -> System.out.println("Bye bye");
                default -> System.out.println("Invalid operation");

            }

        } while (option != 5);
        return null;
    }
}
