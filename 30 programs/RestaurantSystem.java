import java.util.Scanner;

public class RestaurantSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] menu = {"Burger", "Pizza", "Pasta", "Soda"};
        double[] prices = {8.50, 12.00, 10.00, 2.50};
        int[] orderedQty = new int[4];

        System.out.print("Order Type (1 for Dine-in, 2 for Takeaway): ");
        int type = sc.nextInt();
        String orderType = (type == 1) ? "Dine-in" : "Takeaway";

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- MENU ---");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " - $" + prices[i]);
            }
            System.out.println("5. Complete Order");
            System.out.print("Select item: ");
            int item = sc.nextInt();

            switch (item) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.print("Enter quantity: ");
                    orderedQty[item - 1] += sc.nextInt();
                    break;
                case 5:
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

        System.out.println("\nKitchen Notification: Preparing items for " + orderType + " order...");
        double billTotal = 0;
        System.out.println("\n--- FINAL BILL ---");
        for (int i = 0; i < menu.length; i++) {
            if (orderedQty[i] > 0) {
                double cost = orderedQty[i] * prices[i];
                billTotal += cost;
                System.out.println(menu[i] + " x" + orderedQty[i] + " = $" + cost);
            }
        }
        System.out.println("Order Type: " + orderType);
        System.out.println("Total Amount: $" + billTotal);
        sc.close();
    }
}1