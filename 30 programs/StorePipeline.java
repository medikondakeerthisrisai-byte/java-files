import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    double price;
    int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class CartItem {
    Item item;
    int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

public class StorePipeline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Catalog setup
        Item[] inventory = {
            new Item("Laptop", 800.00, 5),
            new Item("Headphones", 50.00, 10),
            new Item("Mouse", 25.00, 0) // Out of stock example
        };

        List<CartItem> cart = new ArrayList<>();
        boolean continueShopping = true; // while loop control

        System.out.println("=== Welcome to the Online Store ===");

        // Main shopping loop
        while (continueShopping) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Browse Items");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an action (1-5): ");

            int action = scanner.nextInt();

            // Switch statement for cart actions
            switch (action) {
                case 1:
                    System.out.println("\n--- Available Products ---");
                    for (int i = 0; i < inventory.length; i++) {
                        System.out.println((i + 1) + ". " + inventory[i].name + " - $" + inventory[i].price + " [Stock: " + inventory[i].stock + "]");
                    }
                    break;

                case 2:
                    System.out.print("\nEnter item number to add to cart (1-" + inventory.length + "): ");
                    int itemChoice = scanner.nextInt() - 1;

                    if (itemChoice >= 0 && itemChoice < inventory.length) {
                        Item selected = inventory[itemChoice];
                        
                        // If-else: check stock availability
                        if (selected.stock > 0) {
                            System.out.print("Enter quantity: ");
                            int qty = scanner.nextInt();

                            if (qty <= selected.stock) {
                                cart.add(new CartItem(selected, qty));
                                selected.stock -= qty; // Reduce available stock
                                System.out.println("Added " + qty + " " + selected.name + "(s) to cart.");
                            } else {
                                System.out.println("Not enough stock available! Current stock: " + selected.stock);
                            }
                        } else {
                            System.out.println("Sorry, " + selected.name + " is OUT OF STOCK!");
                        }
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Your Cart ---");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (CartItem ci : cart) {
                            System.out.println(ci.item.name + " x" + ci.quantity + " = $" + (ci.item.price * ci.quantity));
                        }
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty! Add items before checking out.");
                        break;
                    }

                    // For loop: calculate total bill
                    double totalBill = 0.0;
                    System.out.println("\n--- Order Summary ---");
                    for (int i = 0; i < cart.size(); i++) {
                        CartItem ci = cart.get(i);
                        double subtotal = ci.item.price * ci.quantity;
                        totalBill += subtotal;
                        System.out.println(ci.item.name + " (x" + ci.quantity + "): $" + subtotal);
                    }
                    System.out.println("Total Amount Due: $" + totalBill);

                    // Payment status processing
                    System.out.print("\nSimulating payment processing... Proceed? (yes/no): ");
                    String paymentConfirm = scanner.next();

                    if (paymentConfirm.equalsIgnoreCase("yes")) {
                        System.out.println("Payment Status: SUCCESSFUL");
                        System.out.println("Order Tracking: Order #10492 processed and preparing for dispatch.");
                        cart.clear(); // Empty the cart after successful purchase
                        continueShopping = false; // Exit shopping loop
                    } else {
                        System.out.println("Payment Status: CANCELLED. Items remain in cart.");
                    }
                    break;

                case 5:
                    continueShopping = false;
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}