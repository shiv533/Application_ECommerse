import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<String, Customer> users = new HashMap<>();
    private Map<String, Admin> admins = new HashMap<>();

    public void registerUser(Customer customer) {
        if (users.containsKey(customer.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
        users.put(customer.getUsername(), customer);
    }

    public void registerAdmin(Admin admin) {
        if (admins.containsKey(admin.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
        admins.put(admin.getUsername(), admin);
    }

    public Customer loginUser(String username, String password) {
        Customer user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new IllegalArgumentException("Invalid username or password.");
    }

    public Admin loginAdmin(String username, String password) {
        Admin admin = admins.get(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        throw new IllegalArgumentException("Invalid username or password.");
    }

    public Map<String, Customer> getUsers() {
        return users;
    }

    public Map<String, Admin> getAdmins() {
        return admins;
    }
}
