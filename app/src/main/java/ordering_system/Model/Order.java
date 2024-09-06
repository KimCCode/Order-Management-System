package ordering_system.Model;

public class Order {
    private String orderId;
    private String deliveryDate;
    private String name;
    private String flavour;
    private String size;
    private int quantity;

    public Order(String deliveryDate, String name, String flavour, String size, int quantity) {
        this.deliveryDate = deliveryDate;
        this.name = name;
        this.flavour = flavour;
        this.size = size;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }
}
