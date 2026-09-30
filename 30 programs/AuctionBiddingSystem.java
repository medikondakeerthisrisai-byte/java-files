import java.util.Scanner;

public class AuctionBiddingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter auction item name: ");
        String item = sc.nextLine();
        
        double highestBid = 100.0; // Starting bid
        String highestBidder = "None";
        boolean auctionOpen = true;

        System.out.println("Auction opened for " + item + " starting at $" + highestBid);

        while (auctionOpen) {
            System.out.println("\n1. Place Bid | 2. Close Auction");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter bidder name: ");
                String bidder = sc.nextLine();
                System.out.print("Enter bid amount: ");
                double bid = sc.nextDouble();

                if (bid > highestBid) {
                    highestBid = bid;
                    highestBidder = bidder;
                    System.out.println("New highest bidder: " + bidder + " with $" + bid);
                } else {
                    System.out.println("Bid must be higher than current top bid ($" + highestBid + ").");
                }
            } else if (choice == 2) {
                auctionOpen = false;
            }
        }

        System.out.println("\n--- AUCTION CLOSED ---");
        if (highestBidder.equals("None")) {
            System.out.println("No bids were placed for " + item);
        } else {
            System.out.println("Winner: " + highestBidder + " with winning bid of $" + highestBid);
        }
        sc.close();
    }
}