package com.velocity;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String mobileNumber;
    private List<Product> cart;

    public Customer(String username, String password, String firstName, String lastName, String email, String city, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.cart = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public List<Product> getCart() { return cart; }

    public void addToCart(Product product) {
        this.cart.add(product);
    }

}
