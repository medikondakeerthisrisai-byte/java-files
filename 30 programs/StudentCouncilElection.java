import java.util.Scanner;

public class StudentCouncilElection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Candidate Registration
        String candidate1 = "Alex";
        String candidate2 = "Jordan";
        String candidate3 = "Taylor";

        int votes1 = 0;
        int votes2 = 0;
        int votes3 = 0;

        System.out.print("Enter total number of voters: ");
        int totalVoters = scanner.nextInt();

        // Voting Process (for loop)
        for (int i = 1; i <= totalVoters; i++) {
            System.out.println("\n--- Voter " + i + " ---");
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Validate Voter Eligibility (if-else)
            if (age >= 14) {
                System.out.println("Select a candidate to vote for:");
                System.out.println("1. " + candidate1);
                System.out.println("2. " + candidate2);
                System.out.println("3. " + candidate3);
                System.out.print("Enter candidate choice (1-3): ");
                int choice = scanner.nextInt();

                // Vote Processing (switch)
                switch (choice) {
                    case 1:
                        votes1++;
                        System.out.println("Vote recorded for " + candidate1);
                        break;
                    case 2:
                        votes2++;
                        System.out.println("Vote recorded for " + candidate2);
                        break;
                    case 3:
                        votes3++;
                        System.out.println("Vote recorded for " + candidate3);
                        break;
                    default:
                        System.out.println("Invalid choice! Vote wasted.");
                        break;
                }
            } else {
                System.out.println("Ineligible to vote. Must be 14 or older.");
            }
        }

        // Tally Results
        System.out.println("\n--- Final Vote Count ---");
        System.out.println(candidate1 + ": " + votes1 + " votes");
        System.out.println(candidate2 + ": " + votes2 + " votes");
        System.out.println(candidate3 + ": " + votes3 + " votes");

        // Determine Winner or Tie (if-else-if)
        System.out.println("\n--- Election Result ---");
        if (votes1 > votes2 && votes1 > votes3) {
            System.out.println("Winner: " + candidate1);
        } else if (votes2 > votes1 && votes2 > votes3) {
            System.out.println("Winner: " + candidate2);
        } else if (votes3 > votes1 && votes3 > votes2) {
            System.out.println("Winner: " + candidate3);
        } else if (votes1 == votes2 && votes1 == votes3) {
            System.out.println("Result: Three-way tie between all candidates!");
        } else if (votes1 == votes2 && votes1 > votes3) {
            System.out.println("Result: Tie between " + candidate1 + " and " + candidate2);
        } else if (votes1 == votes3 && votes1 > votes2) {
            System.out.println("Result: Tie between " + candidate1 + " and " + candidate3);
        } else {
            System.out.println("Result: Tie between " + candidate2 + " and " + candidate3);
        }

        scanner.close();
    }
}