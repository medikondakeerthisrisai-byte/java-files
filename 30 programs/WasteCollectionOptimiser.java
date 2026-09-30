import java.util.Scanner;

public class WasteCollectionOptimiser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bins = {"Bin Alpha", "Bin Beta", "Bin Gamma"};
        int[] fillPercent = {90, 40, 85};

        System.out.println("--- ROUTE SCANNING ---");
        for (int i = 0; i < bins.length; i++) {
            System.out.print(bins[i] + " (" + fillPercent[i] + "% full): ");
            if (fillPercent[i] >= 80) {
                System.out.println("FULL -> Assigned to Truck Pickup Route.");
            } else {
                System.out.println("NOT FULL -> Skip pickup.");
            }
        }
        sc.close();
    }
}