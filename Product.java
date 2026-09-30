class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product: " + name);
        System.out.println("Price: Rs." + price);
    }

    public static void main(String[] args) {
        Product p = new Product("Laptop", 55000);
        p.display();
    }
}
