import java.util.Scanner;

public class ATMTransactionSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        int attempts = 0;
        boolean authenticated = false;
        double balance = 5000.0;

        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            int inputPin = sc.nextInt();
            if (inputPin == pin) {
                authenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Invalid PIN. Attempts remaining: " + (3 - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("Card blocked due to too many incorrect attempts.");
            sc.close();
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Balance Check");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current Balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    balance += dep;
                    System.out.println("Deposited $" + dep + ". New Balance: $" + balance);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wdr = sc.nextDouble();
                    if (wdr <= balance) {
                        balance -= wdr;
                        System.out.println("Please collect cash. Remaining Balance: $" + balance);
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;
                case 4:
                    System.out.println("--- Mini Statement ---");
                    System.out.println("Account status: Active | Final Balance: $" + balance);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}