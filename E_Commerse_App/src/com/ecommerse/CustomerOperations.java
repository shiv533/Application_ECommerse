package com.velocity;

import java.util.List;

public class CustomerOperations {
	public void viewProducts(ProductManagement pm) {
        List<Product> sortedProducts = pm.getProductsSortedByName();
        sortedProducts.forEach(product -> {
            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Description: " + product.getDescription() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        });
    }

    public void addToCart(Customer customer, ProductManagement pm, int productId, int quantity) {
        Product product = pm.getProducts().stream().filter(p -> p.getId() == productId).findFirst().orElse(null);
        if (product != null && product.getQuantity() >= quantity) {
            Product cartProduct = new Product(product.getId(), product.getName(), product.getDescription(), product.getPrice(), quantity);
            customer.addToCart(cartProduct);
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found or insufficient quantity.");
        }
    }

    public void viewCart(Customer customer) {
        customer.getCart().forEach(product -> {
            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Description: " + product.getDescription() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        });
    }

    public void purchaseItems(Customer customer) {
        Bill bill = new Bill(customer.getCart());
        bill.displayBill();
        customer.getCart().clear();
        System.out.println("Purchase completed.");
    }

}
