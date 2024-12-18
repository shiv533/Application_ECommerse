
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagement {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProductsSortedByName() {
        return products.stream()
                       .sorted(Comparator.comparing(Product::getName))
                       .collect(Collectors.toList());
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
