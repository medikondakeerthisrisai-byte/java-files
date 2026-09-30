import java.util.Scanner;

public class MonthlyExpenseAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your monthly budget: ");
        double budget = sc.nextDouble();

        double[] categoryExpenses = new double[4]; // 0: Food, 1: Rent, 2: Utilities, 3: Entertainment
        boolean continuing = true;

        while (continuing) {
            System.out.println("\n1. Food | 2. Rent | 3. Utilities | 4. Entertainment | 5. Finish Input");
            System.out.print("Select category to add expense: ");
            int cat = sc.nextInt();

            switch (cat) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.print("Enter expense amount: ");
                    categoryExpenses[cat - 1] += sc.nextDouble();
                    break;
                case 5:
                    continuing = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

        double totalExpenses = 0;
        for (int i = 0; i < categoryExpenses.length; i++) {
            totalExpenses += categoryExpenses[i];
        }

        System.out.println("\n--- EXPENSE SUMMARY REPORT ---");
        System.out.println("Total Monthly Budget: $" + budget);
        System.out.println("Total Actual Spending: $" + totalExpenses);

        if (totalExpenses > budget) {
            System.out.println("Status: OVER BUDGET by $" + (totalExpenses - budget));
        } else {
            System.out.println("Status: WITHIN BUDGET. Remaining savings: $" + (budget - totalExpenses));
        }
        sc.close();
    }
}