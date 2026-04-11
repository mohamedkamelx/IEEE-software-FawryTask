public class Product {
    private String name;
    private double price;
    private int quantity;
    static int counter=0;
    public int id;

    protected Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id=counter;
        counter++;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getID() { return id; }

    public void decreaseQuantity(int amount) {
        quantity -= amount;
    }

    public boolean isExpired() {
        return false;
    }

    public boolean requiresShipping() {
        return false;
    }
}