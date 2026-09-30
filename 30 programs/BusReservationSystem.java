import java.util.Scanner;

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] seats = new boolean[10]; // 10 seats, false = Available, true = Booked
        boolean running = true;

        while (running) {
            System.out.println("\n--- BUS RESERVATION MENU ---");
            System.out.println("1. View Seats\n2. Book Seat\n3. Cancel Seat\n4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Seat Map:");
                    for (int i = 0; i < seats.length; i++) {
                        System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "[BOOKED]" : "[AVAILABLE]"));
                    }
                    break;
                case 2:
                    System.out.print("Enter seat number to book (1-10): ");
                    int bSeat = sc.nextInt() - 1;
                    if (bSeat >= 0 && bSeat < 10) {
                        if (!seats[bSeat]) {
                            seats[bSeat] = true;
                            System.out.println("Seat " + (bSeat + 1) + " successfully booked!");
                        } else {
                            System.out.println("Seat already booked!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter seat number to cancel (1-10): ");
                    int cSeat = sc.nextInt() - 1;
                    if (cSeat >= 0 && cSeat < 10) {
                        if (seats[cSeat]) {
                            seats[cSeat] = false;
                            System.out.println("Reservation for Seat " + (cSeat + 1) + " canceled.");
                        } else {
                            System.out.println("Seat is not booked.");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}