import java.util.Scanner;

public class CourierTracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parcelId = "PKG1001";
        String status = "In Transit";

        boolean systemActive = true;
        while (systemActive) {
            System.out.println("\nParcel ID: " + parcelId + " | Current Status: " + status);
            System.out.println("1. Out for Delivery\n2. Delivered\n3. Exit");
            System.out.print("Choose action: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    status = "Out for Delivery";
                    break;
                case 2:
                    status = "Delivered";
                    break;
                case 3:
                    systemActive = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }

            if (status.equals("Delivered")) {
                System.out.println("\nConfirmation: Parcel " + parcelId + " has been successfully delivered!");
                systemActive = false;
            }
        }
        sc.close();
    }
}