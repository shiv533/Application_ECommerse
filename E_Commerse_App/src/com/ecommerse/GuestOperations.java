import java.util.List;

public class GuestOperations {
    public void viewProducts(ProductManagement pm) {
        List<Product> sortedProducts = pm.getProductsSortedByName();
        sortedProducts.forEach(product -> {
            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Description: " + product.getDescription() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        });
    }
}
