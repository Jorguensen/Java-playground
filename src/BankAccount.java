public class BankAccount {

    private int balance;
    private int previousTransaction;
    private User user;

    public BankAccount(User user){
        this.user = user;
    }
    public void deposit(int amount) {

        if (amount >= 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public int withdraw(int amount) {
        if (balance < amount) {
            System.out.println("You cannot withdraw that amount");
            return 0;
        }

        if (amount >= 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
        return balance;
    }

    public void getPreviousTransactions() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }

        if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));

        } else System.out.println("There is no previous transaction to show");
    }

    public int checkBalance() {
        System.out.println("Balance: " + balance);
        return balance;

    }
}
