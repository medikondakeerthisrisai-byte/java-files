import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = {"Soda", "Chips", "Candy"};
        double[] prices = {1.50, 1.00, 0.75};
        int[] stock = {5, 5, 5};

        System.out.println("--- VENDING MACHINE ---");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - $" + prices[i]);
        }
        System.out.print("Select product code (1-3): ");
        int choice = sc.nextInt() - 1;

        if (choice >= 0 && choice < 3 && stock[choice] > 0) {
            double insertedMoney = 0;
            while (insertedMoney < prices[choice]) {
                System.out.print("Insert money (Current: $" + insertedMoney + " / Needed: $" + prices[choice] + "): $");
                insertedMoney += sc.nextDouble();
            }

            double change = insertedMoney - prices[choice];
            stock[choice]--;
            System.out.println("\nDispensing " + products[choice] + "!");
            if (change > 0) {
                System.out.println("Returning Change: $" + change);
            }
        } else {
            System.out.println("Invalid selection or product out of stock.");
        }
        sc.close();
    }
}