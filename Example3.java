import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[4];

        // Insert data using keyboard
        System.out.println("Enter marks of 4 students:");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }

        // Retrieve data
        System.out.println("Stored marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1)
                    + ": " + marks[i]);
        }

        sc.close();
    }
}
