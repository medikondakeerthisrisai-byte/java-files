public class Employee {
    String name;
    int id;

    // Constructor
    public Employee() {
        this.name = "Unknown";
        this.id = 0;
    }

    // Method to display details
    public void display() {
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee ID: " + this.id);
    }

    // Main execution point
    public static void main(String[] args) {
        Employee e = new Employee();
        e.display();
    }
}
