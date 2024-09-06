package ordering_system.Model;

public class Mooncake {
    private double price;
    private String flavour;
    private String size;
    private Ingredient ingredients;

    public Mooncake(double price, String flavour, String size, Ingredient ingredients) {
        this.price = price;
        this.flavour = flavour;
        this.size = size;
        this.ingredients = ingredients;
    }
}
