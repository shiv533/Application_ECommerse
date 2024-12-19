package com.ecomerce;
public class Admin {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String mobileNumber;

    public Admin(String username, String password, String firstName, String lastName, String email, String city, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.mobileNumber = mobileNumber;
    }

    
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	// Admin-specific methods
	
    public void addProduct(ProductManagement pm, int id, String name, String description, double price, int quantity) {
        Product product = new Product(id, name, description, price, quantity);
        pm.addProduct(product);
        System.out.println("Product added successfully!");
    }

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
