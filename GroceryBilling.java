import java.util.Scanner; 
 
public class GroceryBilling { 
 
    public static void main(String[] args) { 
 
        // Create Scanner object 
        Scanner sc = new Scanner(System.in); 
 
        // Constant price of rice per kg 
        int pricePerKg = 60; 
 
        // Accept customer name 
        System.out.print("Enter Customer Name: "); 
        String customerName = sc.nextLine(); 
 
        // Accept quantity purchased 
        System.out.print("Enter Quantity Purchased (kg): "); 
        double quantity = sc.nextDouble(); 
 
        // Calculate total bill 
        double totalBill = quantity * pricePerKg; 
 
        // Display bill 
        System.out.println("\n=================================="); 
        System.out.println("      GROCERY STORE BILL"); 
        System.out.println("=================================="); 
        System.out.println("Customer Name     : " + customerName); 
        System.out.println("Rice Price        : ₹" + pricePerKg + " per kg"); 
        System.out.println("Quantity Purchased: " + quantity + " kg"); 
        System.out.println("Total Bill        : ₹" + totalBill); 
        System.out.println("=================================="); 
 
        // Close Scanner 
        sc.close(); 
    } 
} 