import java.util.Scanner;

public class WarehouseInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] items = {"Boxes", "Tape", "Pallets"};
        int[] stock = {50, 10, 5};
        int reorderThreshold = 15;

        boolean running = true;
        while (running) {
            System.out.println("\n1. View Stock | 2. Remove Stock | 3. Check Reorders | 4. Exit");
            System.out.print("Select choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i] + ": " + stock[i] + " units");
                    }
                    break;
                case 2:
                    System.out.print("Select Item (1-Boxes, 2-Tape, 3-Pallets): ");
                    int idx = sc.nextInt() - 1;
                    System.out.print("Enter quantity to remove: ");
                    int qty = sc.nextInt();
                    if (qty <= stock[idx]) {
                        stock[idx] -= qty;
                        System.out.println("Removed. Remaining: " + stock[idx]);
                    } else {
                        System.out.println("Insufficient stock!");
                    }
                    break;
                case 3:
                    System.out.println("--- LOW STOCK REORDER REPORT ---");
                    for (int i = 0; i < items.length; i++) {
                        if (stock[i] < reorderThreshold) {
                            System.out.println("ALERT: " + items[i] + " is below threshold (" + stock[i] + " units left). Reorder required!");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}