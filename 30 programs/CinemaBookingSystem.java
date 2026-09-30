import java.util.Scanner;

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] seats = new boolean[5]; // 5 cinema seats
        boolean session = true;

        while (session) {
            System.out.println("\n1. View Seats | 2. Book Seat | 3. Exit");
            System.out.print("Select: ");
            int sel = sc.nextInt();

            switch (sel) {
                case 1:
                    for (int i = 0; i < seats.length; i++) {
                        System.out.println("Seat S" + (i + 1) + ": " + (seats[i] ? "[BOOKED]" : "[FREE]"));
                    }
                    break;
                case 2:
                    System.out.print("Enter seat number (1-5): ");
                    int seatNo = sc.nextInt() - 1;
                    if (seatNo >= 0 && seatNo < 5) {
                        if (!seats[seatNo]) {
                            seats[seatNo] = true;
                            System.out.println("Seat S" + (seatNo + 1) + " successfully booked!");
                        } else {
                            System.out.println("Seat already booked!");
                        }
                    }
                    break;
                case 3:
                    session = false;
                    break;
            }
        }
        sc.close();
    }
}