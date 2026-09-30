import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Donor {
    private String name;
    private String bloodGroup;
    private String phone;

    public Donor(String name, String bloodGroup, String phone) {
        this.name = name;
        this.bloodGroup = bloodGroup.toUpperCase();
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhone() {
        return phone;
    }
}

public class BloodBankSystem {
    private static final List<Donor> donors = new ArrayList<>();
    private static final int LOW_STOCK_THRESHOLD = 2;

    // Stock units for main blood types
    private static int stockAPositive = 5;
    private static int stockANegative = 1;
    private static int stockBPositive = 4;
    private static int stockBNegative = 0;
    private static int stockOPositive = 3;
    private static int stockONegative = 1;
    private static int stockABPositive = 2;
    private static int stockABNegative = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // **while loop**: Continuously monitor stock operations and run menu
        while (running) {
            System.out.println("\n=== BLOOD BANK INVENTORY & DONOR MATCHER ===");
            System.out.println("1. Add Donor Details");
            System.out.println("2. View Blood Stock & Alerts");
            System.out.println("3. Search Matching Donor");
            System.out.println("4. Check Recipient Compatibility");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // **switch**: Handle menu navigation
            switch (choice) {
                case 1:
                    addDonor(scanner);
                    break;
                case 2:
                    checkStockAndAlerts();
                    break;
                case 3:
                    searchDonor(scanner);
                    break;
                case 4:
                    checkCompatibility(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
        scanner.close();
    }

    private static void addDonor(Scanner scanner) {
        System.out.print("Enter donor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter blood group (A+, A-, B+, B-, O+, O-, AB+, AB-): ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        donors.add(new Donor(name, bloodGroup, phone));
        updateStock(bloodGroup, 1);
        System.out.println("Donor added successfully and 1 unit added to stock!");
    }

    private static void updateStock(String bloodGroup, int amount) {
        switch (bloodGroup.toUpperCase()) {
            case "A+": stockAPositive += amount; break;
            case "A-": stockANegative += amount; break;
            case "B+": stockBPositive += amount; break;
            case "B-": stockBNegative += amount; break;
            case "O+": stockOPositive += amount; break;
            case "O-": stockONegative += amount; break;
            case "AB+": stockABPositive += amount; break;
            case "AB-": stockABNegative += amount; break;
            default: System.out.println("Unknown blood group; stock not updated.");
        }
    }

    private static void checkStockAndAlerts() {
        System.out.println("\n--- Current Blood Stock ---");
        System.out.println("A+: " + stockAPositive + " units");
        System.out.println("A-: " + stockANegative + " units");
        System.out.println("B+: " + stockBPositive + " units");
        System.out.println("B-: " + stockBNegative + " units");
        System.out.println("O+: " + stockOPositive + " units");
        System.out.println("O-: " + stockONegative + " units");
        System.out.println("AB+: " + stockABPositive + " units");
        System.out.println("AB-: " + stockABNegative + " units");

        System.out.println("\n--- Low Stock Alerts ---");
        boolean alertTriggered = false;

        // **if-else**: Check each inventory stock against threshold
        if (stockAPositive <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] A+ stock is LOW!"); alertTriggered = true; }
        if (stockANegative <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] A- stock is LOW!"); alertTriggered = true; }
        if (stockBPositive <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] B+ stock is LOW!"); alertTriggered = true; }
        if (stockBNegative <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] B- stock is LOW!"); alertTriggered = true; }
        if (stockOPositive <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] O+ stock is LOW!"); alertTriggered = true; }
        if (stockONegative <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] O- stock is LOW!"); alertTriggered = true; }
        if (stockABPositive <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] AB+ stock is LOW!"); alertTriggered = true; }
        if (stockABNegative <= LOW_STOCK_THRESHOLD) { System.out.println("[ALERT] AB- stock is LOW!"); alertTriggered = true; }

        if (!alertTriggered) {
            System.out.println("All blood groups have sufficient stock levels.");
        }
    }

    private static void searchDonor(Scanner scanner) {
        System.out.print("Enter target blood group to search: ");
        String targetGroup = scanner.nextLine().toUpperCase();

        boolean found = false;
        System.out.println("\n--- Matching Donors ---");

        // **for loop**: Search through donor list
        for (int i = 0; i < donors.size(); i++) {
            Donor d = donors.get(i);
            if (d.getBloodGroup().equalsIgnoreCase(targetGroup)) {
                System.out.println("Name: " + d.getName() + " | Phone: " + d.getPhone());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No donors found with blood group " + targetGroup);
        }
    }

    private static void checkCompatibility(Scanner scanner) {
        System.out.print("Enter Donor Blood Group: ");
        String donorType = scanner.nextLine().toUpperCase();
        System.out.print("Enter Recipient Blood Group: ");
        String recipientType = scanner.nextLine().toUpperCase();

        // **if-else**: Blood group compatibility check logic
        if (donorType.equals("O-")) {
            System.out.println("Compatible: O- is a universal donor!");
        } else if (recipientType.equals("AB+")) {
            System.out.println("Compatible: AB+ is a universal recipient!");
        } else if (donorType.equals(recipientType)) {
            System.out.println("Compatible: Exact blood group match.");
        } else {
            System.out.println("Incompatible: " + donorType + " cannot safely donate to " + recipientType + ".");
        }
    }
}
