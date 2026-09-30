 import java.util.Scanner; 
 
public class SmartLockerAvailability { 
 
    public static void main(String[] args) { 
 
        // Create Scanner object 
        Scanner sc = new Scanner(System.in); 
 
        // Accept locker number from the user 
        System.out.print("Enter Locker Number: "); 
        int lockerNumber = sc.nextInt(); 
 
        // Check whether the locker number is valid 
        if (lockerNumber >= 1 && lockerNumber <= 20) { 
            System.out.println("Locker Available"); 
        } else { 
            System.out.println("Invalid Locker Number"); 
        } 
 
        // Close the Scanner object 
        sc.close(); 
    } 
}
 
 