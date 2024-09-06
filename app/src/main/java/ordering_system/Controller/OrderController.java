package ordering_system.Controller;

import javax.swing.JFrame;

import ordering_system.Manager.OrderManager;

public class OrderController {
    private OrderManager orderManager;
    // private OrderFrame orderPanel;

    // public OrderController (OrderManager orderManager, OrderFrame orderPanel) {
    //     this.orderManager = orderManager;
    //     this.orderPanel = orderPanel;
    //     // orderPanel.addCreateOrderListener(e -> createOrder());
    // }

    public void createOrder() {
        // orderManager.createOrder(orderPanel.getDeliveryDate(), orderPanel.getCustomerName(), orderPanel.getFlavour(),
        //     orderPanel.getSize(), orderPanel.getQuantity(), orderPanel.getNotes());
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
