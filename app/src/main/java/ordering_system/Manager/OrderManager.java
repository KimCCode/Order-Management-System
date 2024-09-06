package ordering_system.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ordering_system.Model.Order;
import ordering_system.Util.OrderFactory;

public class OrderManager {
    List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void createOrder(String deliveryDate, String name, String flavour, String size, int quantity, String notes) {
        orders.add(OrderFactory.createOrder(deliveryDate, name, flavour, size, quantity, notes));
    }

    public void removeOrder(String orderId) {
        orders = orders.stream().filter(o -> !(o.getOrderId().equals(orderId))).collect(Collectors.toList());
    }
}
