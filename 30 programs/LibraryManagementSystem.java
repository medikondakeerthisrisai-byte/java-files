import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    String category;
    boolean available;

    Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static Book[] books = new Book[100];
    static Member[] members = new Member[50];

    static int bookCount = 0;
    static int memberCount = 0;

    // Add Book
    static void addBook() {

        System.out.print("\nEnter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        books[bookCount] = new Book(id, title, author, category);
        bookCount++;

        System.out.println("\nBook added successfully!");
    }

    // Update Book
    static void updateBook() {

        System.out.print("\nEnter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id == id) {

                System.out.print("Enter New Title: ");
                books[i].title = sc.nextLine();

                System.out.print("Enter New Author: ");
                books[i].author = sc.nextLine();

                System.out.print("Enter New Category: ");
                books[i].category = sc.nextLine();

                System.out.println("\nBook updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nBook not found!");
        }
    }

    // Delete Book
    static void deleteBook() {

        System.out.print("\nEnter Book ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id == id) {

                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }

                bookCount--;

                System.out.println("\nBook deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nBook not found!");
        }
    }

    // Register Member
    static void registerMember() {

        System.out.print("\nEnter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members[memberCount] = new Member(id, name);
        memberCount++;

        System.out.println("\nMember registered successfully!");
    }

    // Display Books
    static void displayBooks() {

        if (bookCount == 0) {
            System.out.println("\nNo books available.");
            return;
        }

        System.out.println("\n========== BOOK LIST ==========");

        // for loop
        for (int i = 0; i < bookCount; i++) {

            System.out.println("\nBook ID   : " + books[i].id);
            System.out.println("Title     : " + books[i].title);
            System.out.println("Author    : " + books[i].author);
            System.out.println("Category  : " + books[i].category);

            // if-else
            if (books[i].available) {
                System.out.println("Status    : Available");
            } else {
                System.out.println("Status    : Issued");
            }
        }
    }

    // Search Book
    static void searchBook() {

        sc.nextLine();

        System.out.print("\nEnter title, author or category: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].title.toLowerCase().contains(keyword)
                    || books[i].author.toLowerCase().contains(keyword)
                    || books[i].category.toLowerCase().contains(keyword)) {

                System.out.println("\nBook ID  : " + books[i].id);
                System.out.println("Title    : " + books[i].title);
                System.out.println("Author   : " + books[i].author);
                System.out.println("Category : " + books[i].category);

                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo matching book found!");
        }
    }

    // Issue Book
    static void issueBook() {

        System.out.print("\nEnter Book ID to issue: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id == id) {

                found = true;

                // if-else: checking availability
                if (books[i].available) {

                    books[i].available = false;

                    System.out.println("\nBook issued successfully!");

                } else {

                    System.out.println("\nSorry! Book is already issued.");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("\nBook not found!");
        }
    }

    // Return Book and Calculate Fine
    static void returnBook() {

        System.out.print("\nEnter Book ID to return: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].id == id) {

                found = true;

                if (!books[i].available) {

                    books[i].available = true;

                    System.out.print("Enter number of days late: ");
                    int daysLate = sc.nextInt();

                    // Fine calculation
                    if (daysLate > 0) {

                        double fine = daysLate * 5;

                        System.out.println("\nBook returned successfully!");
                        System.out.println("Fine = Rs. " + fine);

                    } else {

                        System.out.println("\nBook returned successfully!");
                        System.out.println("No fine.");
                    }

                } else {

                    System.out.println("\nThis book was not issued.");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("\nBook not found!");
        }
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        // while loop
        while (true) {

            System.out.println("\n====================================");
            System.out.println("   COMMUNITY LIBRARY MANAGEMENT");
            System.out.println("====================================");

            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Register Member");
            System.out.println("5. Display All Books");
            System.out.println("6. Search Book");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");

            System.out.println("====================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // switch statement
            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    updateBook();
                    break;

                case 3:
                    deleteBook();
                    break;

                case 4:
                    registerMember();
                    break;

                case 5:
                    displayBooks();
                    break;

                case 6:
                    searchBook();
                    break;

                case 7:
                    issueBook();
                    break;

                case 8:
                    returnBook();
                    break;

                case 9:
                    System.out.println(
                        "\nThank you for using Library Management System!"
                    );
                    return;

                default:
                    System.out.println(
                        "\nInvalid choice! Please try again."
                    );
            }
        }
    }
}
