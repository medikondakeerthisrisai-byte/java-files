import java.util.Scanner;

public class OnlineStoreCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] items = {"Laptop", "Phone", "Headphones"};
        double[] prices = {800.0, 500.0, 50.0};
        int[] stock = {2, 5, 10};
        int[] cart = new int[3];

        boolean shopping = true;
        while (shopping) {
            System.out.println("\n--- ITEMS AVAILABLE ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i] + " (Stock: " + stock[i] + ")");
            }
            System.out.println("4. Checkout");
            System.out.print("Choose action: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    int idx = choice - 1;
                    if (stock[idx] > 0) {
                        cart[idx]++;
                        stock[idx]--;
                        System.out.println("Added " + items[idx] + " to cart.");
                    } else {
                        System.out.println("Sorry, item is out of stock!");
                    }
                    break;
                case 4:
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        double totalBill = 0;
        System.out.println("\n--- ORDER CHECKOUT ---");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] > 0) {
                double lineTotal = cart[i] * prices[i];
                totalBill += lineTotal;
                System.out.println(items[i] + " x" + cart[i] + " = $" + lineTotal);
            }
        }

        System.out.println("Total Amount Due: $" + totalBill);
        System.out.println("Payment Status: PAID");
        System.out.println("Order Tracking: Order placed and in pipeline for shipping.");
        sc.close();
    }
}