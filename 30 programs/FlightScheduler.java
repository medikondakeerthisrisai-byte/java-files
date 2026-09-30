import java.util.Scanner;

public class FlightScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] flights = {"AA101", "UA202", "DL303"};
        String[] statuses = {"On Time", "On Time", "On Time"};

        boolean active = true;
        while (active) {
            System.out.println("\n--- FLIGHT BOARD ---");
            for (int i = 0; i < flights.length; i++) {
                System.out.println("Flight: " + flights[i] + " | Status: " + statuses[i]);
            }
            System.out.println("\n1. Update Status | 2. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Select Flight Index (1-3): ");
                int idx = sc.nextInt() - 1;
                System.out.println("Status Options: 1. Delayed | 2. Cancelled | 3. On Time");
                int st = sc.nextInt();

                switch (st) {
                    case 1: statuses[idx] = "Delayed"; break;
                    case 2: statuses[idx] = "Cancelled"; break;
                    case 3: statuses[idx] = "On Time"; break;
                    default: System.out.println("Invalid status.");
                }
            } else if (choice == 2) {
                active = false;
            }
        }
        sc.close();
    }
}