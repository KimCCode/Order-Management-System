package ordering_system.Controller;

import javax.swing.table.DefaultTableModel;

import ordering_system.Dao.OrderDao;
import ordering_system.Exceptions.OrderProcessingException;
import ordering_system.Services.OrderService;
import ordering_system.View.CardArea.Order.CustomerInfoPanel;
import ordering_system.View.CardArea.Order.OrderInfoPanel;
import ordering_system.View.CardArea.Order.OrderPanelBottom;
import ordering_system.View.CardArea.Order.OrderTable;

public class OrderController {
    private OrderPanelBottom orderPanelBottom;
    private OrderInfoPanel orderInfoPanel;
    private CustomerInfoPanel customerInfoPanel;
    private OrderService orderService;
    private OrderTable orderTable;
    private OrderDao orderDao;

    public OrderController (OrderPanelBottom orderPanelBottom, OrderInfoPanel orderInfoPanel, CustomerInfoPanel customerInfoPanel, OrderTable orderTable, OrderService orderService, OrderDao orderDao) {
        this.orderPanelBottom = orderPanelBottom;
        this.orderInfoPanel = orderInfoPanel;
        this.customerInfoPanel = customerInfoPanel;
        this.orderTable = orderTable;
        this.orderService = orderService;
        this.orderDao = orderDao;
        DefaultTableModel orders = displayOrders();
        orderTable.setOrdersTableModel(orders);
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
        orderTable.setOrdersTableModel(displayOrders());
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

    public DefaultTableModel displayOrders() {
        return orderService.displayOrders();
    }
}
