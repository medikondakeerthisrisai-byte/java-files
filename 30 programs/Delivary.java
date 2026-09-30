static String assignTier(char size, double weight) {
    if (size == 'S' && weight <= 1.0) return "SMALL";
    if (size == 'M' || weight <= 5.0) return "MEDIUM"; 
    return "LARGE";
}

static double computeFee(String tier) {
    switch (tier) {
        case "MEDIUM": return 35.0;
        case "LARGE":  return 50.0;
        default:       return 20.0;
    }
}

static void printReceipt(String tier, double fee) {
    System.out.println("Tier: " + tier);
    System.out.printf("Fee: $%.2f%n", fee);
}

public static void main(String[] args) {
    String tier = assignTier('L', 3.2);
    printReceipt(tier, computeFee(tier));
}