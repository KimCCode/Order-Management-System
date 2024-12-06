package ordering_system.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import ordering_system.Database.DataBaseConnection;
import ordering_system.Model.Order;

public class OrderDao {
    // Insert Example
    public void insertOrder(Connection connection, int customerId, int productId, int sizeId, int qty, String date) {
        String sql = "INSERT INTO orders (customerId, productId, sizeId, quantity, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, sizeId);
            preparedStatement.setInt(4, qty);
            preparedStatement.setString(5, date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOrderById(int customer_id) {
        String sql = "SELECT * FROM customers WHERE customerId = ?";
        // 'try-with-resources' -> automatically does clean up
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customer_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrders(Connection connection) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT orders.date, c.name, p.name AS product_name, s.name AS size, orders.quantity " +
             "FROM orders " +
             "JOIN customers c ON c.id = orders.customerId " +
             "JOIN products p ON p.id = orders.productId " +
             "JOIN sizes s ON s.id = orders.sizeId;";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Populate the table model with data from ResultSet
            while (rs.next()) {
                String orderDate = rs.getString("date");
                String customerName = rs.getString("name");
                String flavour = rs.getString("product_name");
                String size = rs.getString("size");
                Integer quantity = rs.getInt("quantity");

                // Add a row to the table model
                orders.add(new Order(orderDate, customerName, flavour, size, quantity));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public int getProfit() {
        String sql = "SELECT SUM(price) as total FROM ORDERS O JOIN SIZES S ON S.id = O.sizeId";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("total");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
