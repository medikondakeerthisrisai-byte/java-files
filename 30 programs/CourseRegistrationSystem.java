import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String name;
    int credits;
    int seatLimit;
    int enrolledCount;
    String day;
    int startHour; // e.g., 9 for 9:00 AM
    int endHour;   // e.g., 11 for 11:00 AM

    public Course(String code, String name, int credits, int seatLimit, String day, int startHour, int endHour) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.seatLimit = seatLimit;
        this.enrolledCount = 0;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public boolean isAvailable() {
        return enrolledCount < seatLimit;
    }
}

public class CourseRegistrationSystem {
    private static final int MAX_CREDITS = 18;

    public static void main(String[] args) {
        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(new Course("CS101", "Intro to Programming", 4, 30, "Monday", 9, 11));
        availableCourses.add(new Course("MATH201", "Calculus I", 3, 25, "Monday", 10, 12)); // Clashes with CS101
        availableCourses.add(new Course("ENG102", "English Composition", 3, 20, "Tuesday", 9, 11));
        availableCourses.add(new Course("PHYS101", "Physics I", 4, 1, "Wednesday", 14, 16)); // Limited seat test
        availableCourses.add(new Course("CS102", "Data Structures", 4, 25, "Thursday", 11, 13));

        List<Course> registeredCourses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueRegistration = true;

        System.out.println("=== Course Registration System ===");

        // while loop: allow repeated registration attempts
        while (continueRegistration) {
            System.out.println("\n--- Available Courses ---");
            for (int i = 0; i < availableCourses.size(); i++) {
                Course c = availableCourses.get(i);
                System.out.printf("%d. [%s] %s | Credits: %d | Schedule: %s %d:00-%d:00 | Seats: %d/%d\n",
                        (i + 1), c.code, c.name, c.credits, c.day, c.startHour, c.endHour, c.enrolledCount, c.seatLimit);
            }

            System.out.print("\nEnter course number to select (or 0 to finish): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                continueRegistration = false;
                break;
            }

            if (choice < 1 || choice > availableCourses.size()) {
                System.out.println("Invalid selection. Try again.");
                continue;
            }

            Course selectedCourse = availableCourses.get(choice - 1);

            // if-else: check seat availability
            if (!selectedCourse.isAvailable()) {
                System.out.println("Error: Registration failed. Course is full.");
                continue;
            } else {
                System.out.println("Seats available. Checking rules...");
            }

            // Credit limit checking
            int currentTotalCredits = 0;

            // for loop: scan selected courses
            for (Course course : registeredCourses) {
                currentTotalCredits += course.credits;
            }

            if (currentTotalCredits + selectedCourse.credits > MAX_CREDITS) {
                System.out.println("Error: Credit limit exceeded! Maximum allowed is " + MAX_CREDITS + " credits.");
                continue;
            }

            // nested if: detect timetable conflict
            boolean clashFound = false;
            for (Course course : registeredCourses) {
                if (course.day.equalsIgnoreCase(selectedCourse.day)) {
                    // Check time overlap
                    if ((selectedCourse.startHour < course.endHour) && (selectedCourse.endHour > course.startHour)) {
                        clashFound = true;
                        System.out.println("Error: Time clash detected with already registered course: " + course.code);
                        break;
                    }
                }
            }

            if (!clashFound) {
                selectedCourse.enrolledCount++;
                registeredCourses.add(selectedCourse);
                System.out.println("Success: Registered for " + selectedCourse.name);
            }

            System.out.print("\nDo you want to add another course? (true/false): ");
            continueRegistration = scanner.nextBoolean();
        }

        // Final Timetable Generation
        System.out.println("\n==================================");
        System.out.println("     YOUR FINAL TIMETABLE        ");
        System.out.println("==================================");
        int finalCredits = 0;
        for (Course course : registeredCourses) {
            System.out.printf("[%s] %s | %s %d:00-%d:00 | %d Credits\n",
                    course.code, course.name, course.day, course.startHour, course.endHour, course.credits);
            finalCredits += course.credits;
        }
        System.out.println("----------------------------------");
        System.out.println("Total Registered Credits: " + finalCredits);
        
        scanner.close();
    }
}