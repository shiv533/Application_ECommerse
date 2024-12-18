
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        ProductManagement productManagement = new ProductManagement();
        AdminOperations adminOperations = new AdminOperations();
        CustomerOperations customerOperations = new CustomerOperations();
        GuestOperations guestOperations = new GuestOperations();
        AppUtilities appUtilities = new AppUtilities(userManagement, productManagement, adminOperations, customerOperations, guestOperations, scanner);

        // Sample Products
        productManagement.addProduct(new Product(101, "Apple MacBook 2020", "8 GB RAM, 256 SSD", 85000, 5));
        productManagement.addProduct(new Product(102, "One Plus Mobile", "16 GB RAM, 128 GB Storage", 37500, 3));

        // Initialize the application with an admin account
        Admin admin = new Admin("admin", "adminpass", "Admin", "User", "admin@example.com", "City", "1234567890");
        userManagement.registerAdmin(admin);

        while (true) {
            System.out.println("Welcome to E-Commerce based application");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Guest View Products");
            System.out.println("4. Admin Access");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    appUtilities.handleUserRegistration();
                    break;
                case "2":
                    appUtilities.handleUserLogin();
                    break;
                case "3":
                    appUtilities.handleGuestViewProducts();
                    break;
                case "4":
                    appUtilities.handleAdminActions(admin);
                    break;
                case "5":
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

