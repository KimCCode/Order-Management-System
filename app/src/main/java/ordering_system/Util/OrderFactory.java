package ordering_system.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import ordering_system.Model.Order;

public class OrderFactory {
    public static Order createOrder(String deliveryDate, String name, String flavour, String size, int quantity, String notes, Double price) {
        return new Order(deliveryDate, name, flavour, size, quantity, price);
    }

    public static Order formatTableEntry(ResultSet rs) throws SQLException {
        String orderDate = rs.getString("date");
        String customerName = rs.getString("name");
        String flavour = rs.getString("product_name");
        String size = rs.getString("size");
        Integer quantity = rs.getInt("quantity");
        Double price = rs.getDouble("price");
        return new Order(orderDate, customerName, flavour, size, quantity, price);
    }

    public static DefaultTableModel buildTable(List<Order> orders) {
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] columnNames = {"Date", "Name", "Size", "Flavour", "Qty", "Total ($)"};
        tableModel.setColumnIdentifiers(columnNames);
        for (Order order : orders) {
            int qty = order.getQty();
            Object[] rowData = {
                order.getDeliveryDate(),
                order.getCustomerName(),
                order.getSize(),
                order.getFlavour(),
                qty,
                qty * order.getPrice()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
