import java.util.Scanner; 

public class LogicalOperatorsExample { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        
        // Accept user inputs 
        System.out.print("Enter your age: "); 
        int age = sc.nextInt(); 
        
        System.out.print("Enter your percentage: "); 
        double percentage = sc.nextDouble(); 
        
        // Logical AND (&&) 
        boolean scholarship = (age >= 18 && percentage >= 75); 
 
        // Logical OR (||) 
        boolean admission = (age >= 18 || percentage >= 75); 
 
        // Logical NOT (!) 
        boolean notEligible = !(age >= 18); 
 
        // Display results 
        System.out.println("\nLogical Operator Results:"); 
 
        System.out.println("Eligible for Scholarship (Age >=18 AND Percentage >=75): " + scholarship); 
 
        System.out.println("Eligible for Admission (Age >=18 OR Percentage >=75): " + admission); 
 
        System.out.println("Not Eligible by Age (!Age >=18): " + notEligible); 
 
        sc.close(); 
    } 
}