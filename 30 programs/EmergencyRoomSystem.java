import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String symptomCategory;
    private String priorityLevel;
    private String assignedDoctor;

    public Patient(String name, int age, String symptomCategory, String priorityLevel) {
        this.name = name;
        this.age = age;
        this.symptomCategory = symptomCategory;
        this.priorityLevel = priorityLevel;
        this.assignedDoctor = "Unassigned";
    }

    public String getName() { return name; }
    public String getPriorityLevel() { return priorityLevel; }
    public void setAssignedDoctor(String doctor) { this.assignedDoctor = doctor; }

    @Override
    public String toString() {
        return "Patient: " + name + " | Age: " + age + " | Symptom: " + symptomCategory + 
               " | Priority: " + priorityLevel + " | Doctor: " + assignedDoctor;
    }
}

public class EmergencyRoomSystem {
    private static Queue<Patient> criticalQueue = new LinkedList<>();
    private static Queue<Patient> moderateQueue = new LinkedList<>();
    private static Queue<Patient> mildQueue = new LinkedList<>();
    private static ArrayList<Patient> allPatients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== HOSPITAL EMERGENCY ROOM TRIAGE SYSTEM ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Display Waiting List");
            System.out.println("3. Assign Doctor & Process Next Patient");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    displayWaitingList();
                    break;
                case 3:
                    processNextPatient();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system. Stay safe!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Patient Registration & Priority Assignment
    private static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nSelect Symptom Category:");
        System.out.println("1. Chest Pain / Unconsciousness");
        System.out.println("2. High Fever / Fractures");
        System.out.println("3. Minor Cuts / Cold & Flu");
        System.out.print("Choice: ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        String symptomCategory = "";
        String priorityLevel = "";

        // switch: select symptoms category
        switch (categoryChoice) {
            case 1:
                symptomCategory = "Critical Emergency";
                break;
            case 2:
                symptomCategory = "Moderate Condition";
                break;
            case 3:
                symptomCategory = "Mild Issue";
                break;
            default:
                symptomCategory = "General";
        }

        // if-else-if: determine priority level
        if (categoryChoice == 1) {
            priorityLevel = "Critical";
        } else if (categoryChoice == 2) {
            priorityLevel = "Moderate";
        } else {
            priorityLevel = "Mild";
        }

        Patient patient = new Patient(name, age, symptomCategory, priorityLevel);
        
        // Queue management
        if (priorityLevel.equals("Critical")) {
            criticalQueue.add(patient);
        } else if (priorityLevel.equals("Moderate")) {
            moderateQueue.add(patient);
        } else {
            mildQueue.add(patient);
        }

        allPatients.add(patient);
        System.out.println("Patient successfully registered with Priority: " + priorityLevel);
    }

    // for loop: display waiting list
    private static void displayWaitingList() {
        System.out.println("\n--- Current Patient Registry ---");
        if (allPatients.isEmpty()) {
            System.out.println("No patients currently in the system.");
            return;
        }

        for (int i = 0; i < allPatients.size(); i++) {
            System.out.println((i + 1) + ". " + allPatients.get(i));
        }
    }

    // while loop: process patients in queue & Doctor assignment
    private static void processNextPatient() {
        Patient currentPatient = null;

        // Process highest priority queue first
        if (!criticalQueue.isEmpty()) {
            currentPatient = criticalQueue.poll();
        } else if (!moderateQueue.isEmpty()) {
            currentPatient = moderateQueue.poll();
        } else if (!mildQueue.isEmpty()) {
            currentPatient = mildQueue.poll();
        }

        if (currentPatient == null) {
            System.out.println("No patients waiting in queue.");
            return;
        }

        System.out.println("\nProcessing Patient: " + currentPatient.getName() + " (" + currentPatient.getPriorityLevel() + ")");
        System.out.print("Assign Doctor Name: ");
        String doctor = scanner.nextLine();
        currentPatient.setAssignedDoctor(doctor);

        System.out.println("Patient " + currentPatient.getName() + " has been assigned to Dr. " + doctor + " for immediate treatment.");
    }
}