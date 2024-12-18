import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Database {
    private Connection connect() throws SQLException {
        // Update the connection URL to your Oracle database
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "System";
        String password = "System";
        return DriverManager.getConnection(url, user, password);
    }

    public void storeProducts(List<Product> products) {
        String sql = "INSERT INTO products(id, name, description, price, quantity) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Product product : products) {
                pstmt.setInt(1, product.getId());
                pstmt.setString(2, product.getName());
                pstmt.setString(3, product.getDescription());
                pstmt.setDouble(4, product.getPrice());
                pstmt.setInt(5, product.getQuantity());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
