import java.util.Scanner;

public class CarRentalManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fleet = {"Sedan", "SUV", "Truck"};
        boolean[] available = {true, true, true};
        boolean managing = true;

        while (managing) {
            System.out.println("\n1. Display Fleet | 2. Rent Car | 3. Return Car | 4. Exit");
            System.out.print("Option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    for (int i = 0; i < fleet.length; i++) {
                        System.out.println((i + 1) + ". " + fleet[i] + " - " + (available[i] ? "Available" : "Rented"));
                    }
                    break;
                case 2:
                    System.out.print("Select vehicle type (1-Sedan, 2-SUV, 3-Truck): ");
                    int rIdx = sc.nextInt() - 1;
                    if (rIdx >= 0 && rIdx < 3 && available[rIdx]) {
                        available[rIdx] = false;
                        System.out.println("Vehicle rented successfully!");
                    } else {
                        System.out.println("Vehicle unavailable.");
                    }
                    break;
                case 3:
                    System.out.print("Select vehicle to return (1-3): ");
                    int retIdx = sc.nextInt() - 1;
                    if (retIdx >= 0 && retIdx < 3 && !available[retIdx]) {
                        available[retIdx] = true;
                        System.out.println("Vehicle returned and set to available.");
                    }
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
        }
        sc.close();
    }
}