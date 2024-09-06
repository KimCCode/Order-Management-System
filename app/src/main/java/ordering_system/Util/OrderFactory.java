package ordering_system.Util;

import ordering_system.Model.Order;

public class OrderFactory {
    public static Order createOrder(String deliveryDate, String name, String flavour, String size, int quantity, String notes) {
        return new Order(deliveryDate, name, flavour, size, quantity);
    }
}
