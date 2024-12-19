package com.ecomerce;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppUtilities {
    private final UserManagement userManagement;
    private final ProductManagement productManagement;
    private final AdminOperations adminOperations;
    private final CustomerOperations customerOperations;
    private final GuestOperations guestOperations;
    private final Scanner scanner;

    public AppUtilities(UserManagement userManagement, ProductManagement productManagement, AdminOperations adminOperations, CustomerOperations customerOperations, GuestOperations guestOperations, Scanner scanner) {
        this.userManagement = userManagement;
        this.productManagement = productManagement;
        this.adminOperations = adminOperations;
        this.customerOperations = customerOperations;
        this.guestOperations = guestOperations;
        this.scanner = scanner;
    }

    public void handleUserRegistration() {
        try {
            System.out.println("Enter the first name>>");
            String firstName = scanner.nextLine();
            System.out.println("Enter the last name>>");
            String lastName = scanner.nextLine();
            System.out.println("Enter the username>>");
            String username = scanner.nextLine();
            if (userManagement.getUsers().containsKey(username)) throw new IllegalArgumentException("Username already exists.");
            System.out.println("Enter the password>>");
            String password = scanner.nextLine();
            System.out.println("Enter the city>>");
            String city = scanner.nextLine();
            System.out.println("Enter the mail id>>");
            String email = scanner.nextLine();
            System.out.println("Enter the mobile number>>");
            String mobileNumber = scanner.nextLine();

            Customer customer = new Customer(username, password, firstName, lastName, email, city, mobileNumber);
            userManagement.registerUser(customer);
            System.out.println("User registered successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void handleUserLogin() {
        System.out.println("Enter the username>>");
        String loginUsername = scanner.nextLine();
        System.out.println("Enter the password>>");
        String loginPassword = scanner.nextLine();

        try {
            Customer customer = userManagement.loginUser(loginUsername, loginPassword);
            System.out.println("Login successful!");
            handleCustomerActions(customer);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void handleCustomerActions(Customer customer) {
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Purchase Items");
            System.out.println("5. Logout");

            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    customerOperations.viewProducts(productManagement);
                    break;
                case "2":
                    System.out.println("Enter the product id to buy product>>");
                    int productId = getValidIntegerInput();
                    System.out.println("Enter the quantity>>");
                    int qty = getValidIntegerInput();
                    customerOperations.addToCart(customer, productManagement, productId, qty);
                    break;
                case "3":
                    customerOperations.viewCart(customer);
                    break;
                case "4":
                    customerOperations.purchaseItems(customer);
                    break;
                case "5":
                    System.out.println("Logout successful!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void handleAdminActions(Admin admin) {
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Product");
            System.out.println("2. Check Quantity");
            System.out.println("3. Check Registered Users");
            System.out.println("4. Check User History");
            System.out.println("5. Calculate Bill");
            System.out.println("6. Display Amount to End User");
            System.out.println("7. Logout");

            String adminChoice = scanner.nextLine();

            switch (adminChoice) {
                case "1":
                    try {
                        System.out.println("Enter Product Id>>");
                        int id = getValidIntegerInput();
                        System.out.println("Enter Product Name>>");
                        String name = scanner.nextLine();
                        if (name.isEmpty()) throw new IllegalArgumentException("Product name cannot be empty.");
                        System.out.println("Enter Product Description>>");
                        String desc = scanner.nextLine();
                        System.out.println("Enter Quantity>>");
                        int quantity = getValidIntegerInput();
                        System.out.println("Enter Price>>");
                        double price = getValidDoubleInput();
                        productManagement.addProduct(new Product(id, name, desc, price, quantity));
                        System.out.println("Product added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Enter Product Id>>");
                    int checkProductId = getValidIntegerInput();
                    adminOperations.checkQuantity(productManagement, checkProductId);
                    break;
                case "3":
                    adminOperations.checkRegisteredUsers(userManagement);
                    break;
                case "4":
                    System.out.println("Enter username>>");
                    String checkUsername = scanner.nextLine();
                    adminOperations.checkUserHistory(userManagement, checkUsername);
                    break;
                case "5":
                    System.out.println("Enter username>>");
                    String billUsername = scanner.nextLine();
                    adminOperations.calculateBill(userManagement, billUsername);
                    break;
                case "6":
                    System.out.println("Enter username>>");
                    String displayUsername = scanner.nextLine();
                    adminOperations.displayAmountToEndUser(userManagement, displayUsername);
                    break;
                case "7":
                    System.out.println("Logout successful!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void handleGuestViewProducts() {
        guestOperations.viewProducts(productManagement);
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private double getValidDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
