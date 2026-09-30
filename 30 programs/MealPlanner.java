import java.util.Scanner;

public class MealPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[] selectedMeals = new String[7];

        System.out.println("--- WEEKLY MEAL PLANNER ---");
        for (int i = 0; i < 7; i++) {
            System.out.println("Day " + (i + 1) + " (" + days[i] + ") Meal:");
            System.out.println("1. Pasta | 2. Rice Bowl | 3. Salad");
            System.out.print("Choice: ");
            int m = sc.nextInt();

            switch (m) {
                case 1: selectedMeals[i] = "Pasta (Needs Pasta & Sauce)"; break;
                case 2: selectedMeals[i] = "Rice Bowl (Needs Rice & Veggies)"; break;
                case 3: selectedMeals[i] = "Salad (Needs Greens & Dressing)"; break;
                default: selectedMeals[i] = "Basic Meal"; break;
            }
        }

        System.out.println("\n--- AUTO-GENERATED GROCERY LIST ---");
        for (int i = 0; i < 7; i++) {
            System.out.println(days[i] + ": " + selectedMeals[i]);
        }
        sc.close();
    }
}