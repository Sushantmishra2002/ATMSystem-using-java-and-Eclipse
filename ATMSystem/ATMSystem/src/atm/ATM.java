package atm;

import atm.user.User;
import atm.operations.Operations;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Set your PIN: ");
        int pin = scanner.nextInt();

        System.out.print("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();

        User user = new User(name, pin, initialBalance);
        Operations operations = new Operations(user);

        System.out.println("\nWelcome to the ATM, " + name + "!");
        System.out.print("Enter PIN to access your account: ");
        int enteredPin = scanner.nextInt();

        if (user.verifyPin(enteredPin)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + operations.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        operations.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        operations.withdraw(withdrawAmount);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scanner.close();
    }
}
