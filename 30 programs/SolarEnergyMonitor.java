import java.util.Scanner;

public class SolarEnergyMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] dailyGen = new double[7];
        double[] dailyCons = new double[7];

        System.out.println("--- Record Solar Readings for 7 Days ---");
        for (int day = 0; day < 7; day++) {
            System.out.print("Day " + (day + 1) + " Generation (kWh): ");
            dailyGen[day] = sc.nextDouble();
            System.out.print("Day " + (day + 1) + " Consumption (kWh): ");
            dailyCons[day] = sc.nextDouble();
        }

        System.out.println("\n--- DAILY ENERGY REPORT ---");
        for (int day = 0; day < 7; day++) {
            double net = dailyGen[day] - dailyCons[day];
            if (net >= 0) {
                System.out.println("Day " + (day + 1) + ": SURPLUS power of " + net + " kWh");
            } else {
                System.out.println("Day " + (day + 1) + ": DEFICIT power of " + Math.abs(net) + " kWh");
            }
        }
        sc.close();
    }
}