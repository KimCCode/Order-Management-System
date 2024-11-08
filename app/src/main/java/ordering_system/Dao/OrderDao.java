package ordering_system.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ordering_system.Database.DataBaseConnection;

public class OrderDao {
    // Insert Example
    public void insertOrder(Connection connection, int customerId, int productId, int sizeId, int qty, String date) {
        String sql = "INSERT INTO order_items (customerId, productId, sizeId, quantity, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, qty);
            preparedStatement.setInt(4, sizeId);
            preparedStatement.setString(5, date);
            preparedStatement.executeUpdate();

            System.out.println("Order inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select Example
    public void fetchOrders() {
        String sql = "SELECT * FROM customers";
        // 'try-with-resources' -> automatically does clean up
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getOrderById(int customer_id) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        // 'try-with-resources' -> automatically does clean up
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customer_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
