package ordering_system.Controller;

import ordering_system.Services.OrderService;
import ordering_system.View.CardArea.Order.CustomerInfoPanel;
import ordering_system.View.CardArea.Order.OrderInfoPanel;
import ordering_system.View.CardArea.Order.OrderPanelBottom;

public class OrderController {
    private OrderPanelBottom orderPanelBottom;
    private OrderInfoPanel orderInfoPanel;
    private CustomerInfoPanel customerInfoPanel;
    private OrderService orderService;

    public OrderController (OrderPanelBottom orderPanelBottom, OrderInfoPanel orderInfoPanel, CustomerInfoPanel customerInfoPanel, OrderService orderService) {
        this.orderPanelBottom = orderPanelBottom;
        this.orderInfoPanel = orderInfoPanel;
        this.customerInfoPanel = customerInfoPanel;
        this.orderService = orderService;
        orderPanelBottom.setPlaceOrderAction(e -> handlePlaceOrder(
            customerInfoPanel.getNameField(),
            customerInfoPanel.getPhoneField(),
            customerInfoPanel.getDateField(),
            orderInfoPanel.getMooncakeSize(),
            orderInfoPanel.getFlavour(),
            orderInfoPanel.getQty()
        ));
    }

    public void handlePlaceOrder(String customerName, String phone, String date, String size, String flavour, int qty) {
        orderService.placeOrder(customerName, phone, date, size, flavour, qty);
        orderPanelBottom.showSuccessMessage();
    }

    public void sumUp() {
        // orderPanel.getSumButton().addActionListener(e -> orderManager.createOrder(deliveryDate, name, flavour, size, quantity, notes));
    }
    // public void removeOrder(String orderId) {
    //     orderPanel.getButton().addActionListener(e -> orderManager.removeOrder(orderId));
    // }

    // public String viewAllOrders() {
    //     return toString();
    // }

    // public String viewOrdersOnDate(String date) {
    //     List<Order> specificOrders = orders.stream().filter(o -> o.getDeliveryDate() == date).toList();
    //     String result = "Orders[";
    //     for (int i = 0; i < specificOrders.size(); i++) {
    //         if (i == specificOrders.size() - 1) {
    //             result += specificOrders.get(i).toString() + "]";
    //         } else {
    //             result += specificOrders.get(i).toString() + ",";
    //         }
    //     }
    //     return result;
    // }

    // public int totalOrders() {
    //     return orders.size();
    // }

    // @Override
    // public String toString() {
    //     return "Orders[ + " + orders + "]";
    // }
}
