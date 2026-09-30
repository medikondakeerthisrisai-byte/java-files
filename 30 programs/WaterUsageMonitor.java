import java.util.Scanner;

public class WaterUsageMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            System.out.print("Enter monthly water usage (in Liters): ");
            double usage = sc.nextDouble();
            double bill = 0;

            if (usage <= 1000) {
                bill = usage * 0.05;
            } else if (usage <= 3000) {
                bill = (1000 * 0.05) + ((usage - 1000) * 0.08);
            } else {
                bill = (1000 * 0.05) + (2000 * 0.08) + ((usage - 3000) * 0.12);
            }

            System.out.println("Total Water Bill: $" + bill);

            System.out.print("Calculate another month? (1-Yes / 2-No): ");
            if (sc.nextInt() != 1) {
                continueInput = false;
            }
        }
        sc.close();
    }
}