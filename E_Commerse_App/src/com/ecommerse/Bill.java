package com.velocity;

import java.util.List;


public class Bill {
	private List<Product> purchasedProducts;

    public Bill(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public double calculateTotal() {
        return purchasedProducts.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    }

    public void displayBill() {
        purchasedProducts.forEach(p -> System.out.println(p.getName() + " - " + p.getPrice() + " x " + p.getQuantity()));
        System.out.println("Total Amount: " + calculateTotal());
    }

}
