package atm.operations;

import atm.user.User;

public class Operations {
    private User user;

    public Operations(User user) {
        this.user = user;
    }

    public double getBalance() {
        return user.getAccount().getBalance();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            double newBalance = user.getAccount().getBalance() + amount;
            user.getAccount().setBalance(newBalance);
            System.out.println("Deposit successful. New balance: $" + newBalance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= user.getAccount().getBalance()) {
            double newBalance = user.getAccount().getBalance() - amount;
            user.getAccount().setBalance(newBalance);
            System.out.println("Withdrawal successful. New balance: $" + newBalance);
        } else if (amount > user.getAccount().getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}
