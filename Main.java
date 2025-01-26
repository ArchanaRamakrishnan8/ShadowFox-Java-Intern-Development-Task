import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.initialize(); // Initialize the database and tables
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        Scanner sc = new Scanner(System.in);
        int choice;
        boolean loggedIn = false;

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Book");
            System.out.println("4. Search Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User.register(username, password);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    loggedIn = User.login(username, password);
                    if (loggedIn) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 3:
                    if (!loggedIn) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book.addBook(title, author);
                    break;

                case 4:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    Book.searchBooks(keyword);
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
}
