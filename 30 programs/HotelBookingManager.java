import java.util.Scanner;

public class HotelBookingManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] roomTypes = {"Standard", "Deluxe", "Suite"};
        double[] prices = {100.0, 180.0, 300.0};
        boolean[] isOccupied = new boolean[3];
        boolean running = true;

        while (running) {
            System.out.println("\n1. Check Availability | 2. Book Room | 3. Check-out & Bill | 4. Exit");
            System.out.print("Select choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < roomTypes.length; i++) {
                        System.out.println("Room " + (i + 1) + " (" + roomTypes[i] + "): " + (isOccupied[i] ? "Occupied" : "Vacant"));
                    }
                    break;
                case 2:
                    System.out.print("Select Room (1-Standard, 2-Deluxe, 3-Suite): ");
                    int rIndex = sc.nextInt() - 1;
                    if (rIndex >= 0 && rIndex < 3) {
                        if (!isOccupied[rIndex]) {
                            isOccupied[rIndex] = true;
                            System.out.println("Room booked successfully!");
                        } else {
                            System.out.println("Room is currently occupied.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter room number checking out (1-3): ");
                    int outIdx = sc.nextInt() - 1;
                    if (outIdx >= 0 && outIdx < 3 && isOccupied[outIdx]) {
                        System.out.print("Enter number of nights stayed: ");
                        int nights = sc.nextInt();
                        double bill = nights * prices[outIdx];
                        isOccupied[outIdx] = false;
                        System.out.println("Check-out complete. Total Bill: $" + bill);
                    } else {
                        System.out.println("Invalid room selection or room is not occupied.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
        sc.close();
    }
}