package com.ecomerce;

import java.util.List;

public class AdminOperations {
    public void checkQuantity(ProductManagement pm, int productId) {
        Product product = pm.getProducts().stream().filter(p -> p.getId() == productId).findFirst().orElse(null);
        if (product != null) {
            System.out.println("Quantity for Product ID " + productId + " is " + product.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void checkRegisteredUsers(UserManagement um) {
        um.getUsers().values().forEach(user -> {
            System.out.println(user.getUsername() + " - " + user.getFirstName() + " " + user.getLastName());
        });
    }

    public void checkUserHistory(UserManagement um, String username) {
        Customer customer = um.getUsers().get(username);
        if (customer != null) {
            System.out.println("History for " + username + ":");
            customer.getCart().forEach(product -> {
                System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Description: " + product.getDescription() + ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
            });
        } else {
            System.out.println("No history available or user not found.");
        }
    }

    public void addProduct(ProductManagement pm, int id, String name, String description, double price, int quantity) {
        Product product = new Product(id, name, description, price, quantity);
        pm.addProduct(product);
        System.out.println("Product added successfully!");
    }

    public void calculateBill(UserManagement um, String username) {
        Customer customer = um.getUsers().get(username);
        if (customer != null) {
            Bill bill = new Bill(customer.getCart());
            double totalAmount = bill.calculateTotal();
            System.out.println("Total bill for " + username + ": " + totalAmount);
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayAmountToEndUser(UserManagement um, String username) {
        calculateBill(um, username); 
        // Reusing the calculateBill method to display amount to end user
    }
}
