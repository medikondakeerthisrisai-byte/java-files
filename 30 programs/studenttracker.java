import java.util.Scanner;

public class StudentTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Student Info
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        // Attendance Input with Validation
        double attendance = -1;
        while (attendance < 0 || attendance > 100) {
            System.out.print("Enter Attendance Percentage (0-100): ");
            if (scanner.hasNextDouble()) {
                attendance = scanner.nextDouble();
                if (attendance < 0 || attendance > 100) {
                    System.out.println("Invalid input! Attendance must be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); 
            }
        }

        // Subjects & Marks Input
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            double mark = -1;
            while (mark < 0 || mark > 100) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                if (scanner.hasNextDouble()) {
                    mark = scanner.nextDouble();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid marks! Must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next();
                }
            }
            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculations
        double average = totalMarks / numSubjects;
        char grade;

        // Grade assignment using else-if ladder
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Exam eligibility check using if-else
        boolean isEligible = attendance >= 75.0;

        // Student Report Generation
        System.out.println("\n------------------------------------");
        System.out.println("          STUDENT REPORT            ");
        System.out.println("------------------------------------");
        System.out.println("Name         : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Attendance   : " + attendance + "%");
        
        if (isEligible) {
            System.out.println("Exam Status  : Eligible for Examinations");
        } else {
            System.out.println("Exam Status  : NOT Eligible (Attendance below 75%)");
        }

        System.out.println("Total Marks  : " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average      : %.2f%%\n", average);
        System.out.println("Grade        : " + grade);
        System.out.println("------------------------------------");

        scanner.close();
    }
}