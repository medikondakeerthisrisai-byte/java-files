import java.util.Scanner;

class Student {
    String studentName;kee
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Constructor
    Student(String name, int roll, double mark, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        marks = mark;
        courseName = course;
        courseCredits = credits;
    }

    // Calculate fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        if (marks >= 50)
            return true;
        else
            return false;
    }

    // Calculate scholarship
    double calculateScholarship() {
        if (marks >= 85)
            return 20;
        else if (marks >= 70)
            return 10;
        else
            return 0;
    }

    // Calculate final fee
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();
        return fee - (fee * scholarship / 100);
    }

    // Display details
    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: Eligible");
        System.out.println("Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: " + calculateScholarship() + "%");
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double mark = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, mark, course, credits);

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration.");
        }

        sc.close();
    }
}