import java.util.Scanner;

public class ParkingLotManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 2 Floors, 3 Slots per floor
        boolean[][] parking = new boolean[2][3]; // false = Empty, true = Occupied
        boolean active = true;

        while (active) {
            System.out.println("\n1. Park Vehicle | 2. Exit Vehicle | 3. Display Empty Slots | 4. Quit");
            System.out.print("Choose action: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                boolean slotFound = false;
                for (int f = 0; f < 2; f++) {
                    for (int s = 0; s < 3; s++) {
                        if (!parking[f][s]) {
                            parking[f][s] = true;
                            System.out.println("Vehicle parked at Floor " + (f + 1) + ", Slot " + (s + 1));
                            slotFound = true;
                            break;
                        }
                    }
                    if (slotFound) break;
                }
                if (!slotFound) System.out.println("Parking Lot is Full!");
            } else if (choice == 2) {
                System.out.print("Enter Floor (1-2): ");
                int f = sc.nextInt() - 1;
                System.out.print("Enter Slot (1-3): ");
                int s = sc.nextInt() - 1;

                if (f >= 0 && f < 2 && s >= 0 && s < 3) {
                    if (parking[f][s]) {
                        parking[f][s] = false;
                        double fee = 10.0; // Flat fee
                        System.out.println("Vehicle exited from Floor " + (f + 1) + ", Slot " + (s + 1) + ". Fee: $" + fee);
                    } else {
                        System.out.println("Slot is already empty.");
                    }
                }
            } else if (choice == 3) {
                System.out.println("--- EMPTY SLOTS ---");
                for (int f = 0; f < 2; f++) {
                    for (int s = 0; s < 3; s++) {
                        if (!parking[f][s]) {
                            System.out.println("Floor " + (f + 1) + ", Slot " + (s + 1));
                        }
                    }
                }
            } else if (choice == 4) {
                active = false;
            }
        }
        sc.close();
    }
}