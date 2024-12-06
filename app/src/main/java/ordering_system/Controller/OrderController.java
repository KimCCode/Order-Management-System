package ordering_system.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import ordering_system.Dao.OrderDao;
import ordering_system.Dao.ProductDao;
import ordering_system.Database.DataBaseConnection;
import ordering_system.Exceptions.OrderProcessingException;
import ordering_system.Model.Order;
import ordering_system.Services.OrderService;
import ordering_system.View.CardArea.Order.CustomerInfoPanel;
import ordering_system.View.CardArea.Order.OrderInfoPanel;
import ordering_system.View.CardArea.Order.OrderPanelBottom;
import ordering_system.View.CardArea.Order.OrderTable;
import ordering_system.View.CardArea.ViewOrder.ViewOrderPanel;

public class OrderController {
    private OrderPanelBottom orderPanelBottom;
    private OrderInfoPanel orderInfoPanel;
    private CustomerInfoPanel customerInfoPanel;
    private OrderService orderService;
    private OrderTable orderTable;
    private OrderDao orderDao;
    private ProductDao productDao;
    private ViewOrderPanel viewOrderPanel;

    public OrderController (OrderPanelBottom orderPanelBottom, OrderInfoPanel orderInfoPanel, CustomerInfoPanel customerInfoPanel, OrderTable orderTable, OrderService orderService, OrderDao orderDao, ProductDao productDao, ViewOrderPanel viewOrderPanel) {
        this.orderPanelBottom = orderPanelBottom;
        this.orderInfoPanel = orderInfoPanel;
        this.customerInfoPanel = customerInfoPanel;
        this.viewOrderPanel = viewOrderPanel;
        this.orderTable = orderTable;
        this.orderService = orderService;
        this.orderDao = orderDao;
        this.productDao = productDao;
        DefaultTableModel orders = getOrders();
        orderTable.setOrdersTableModel(orders);
        viewOrderPanel.setOrdersTableModel(orders);
        orderPanelBottom.setPlaceOrderAction(e -> handlePlaceOrder(
            customerInfoPanel.getNameField(),
            customerInfoPanel.getPhoneField(),
            customerInfoPanel.getDateField(),
            orderInfoPanel.getMooncakeSize(),
            orderInfoPanel.getFlavour(),
            orderInfoPanel.getQty()
        ));
        
    }

    public void refreshTable() {
        orderTable.setOrdersTableModel(getOrders());
    }

    public void handlePlaceOrder(String customerName, String phone, String date, String size, String flavour, int qty) {
        try {
            if (customerName.equals("")) {
                throw new OrderProcessingException();
            }
            orderService.placeOrder(customerName, phone, date, size, flavour, qty);
            orderPanelBottom.showSuccessMessage();
            refreshTable();
        } catch (OrderProcessingException e) {
            orderPanelBottom.showErrorMessage();
        }
    }

    public DefaultTableModel getOrders() {
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] columnNames = {"Date", "Name", "Size", "Flavour", "Qty", "Total ($)"};
        tableModel.setColumnIdentifiers(columnNames);

        try (Connection connection = DataBaseConnection.getConnection()) {
            List<Order> orders = orderDao.getOrders(connection);
            
            // Define column names for JTable
            for (Order order : orders) {
                int qty = order.getQty();
                Object[] rowData = {
                    order.getDeliveryDate(),
                    order.getCustomerName(),
                    order.getSize(),
                    order.getFlavour(),
                    qty,
                    qty * productDao.getProductPrice(connection, order.getSize())
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableModel;
    }
}
