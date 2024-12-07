package ordering_system.Model;

public class Order {
    private String orderId;
    private String deliveryDate;
    private String name;
    private String flavour;
    private String size;
    private int quantity;
    private Double price;

    public Order(String deliveryDate, String name, String flavour, String size, int quantity, Double price) {
        this.deliveryDate = deliveryDate;
        this.name = name;
        this.flavour = flavour;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getCustomerName() {
        return name;
    }

    public String getFlavour() {
        return flavour;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
