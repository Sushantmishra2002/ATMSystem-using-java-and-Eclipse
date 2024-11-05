package atm.user;

public class User {
    private String name;
    private int pin;
    private Account account;

    public User(String name, int pin, double initialBalance) {
        this.name = name;
        this.pin = pin;
        this.account = new Account(initialBalance);
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
