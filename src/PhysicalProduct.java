public class PhysicalProduct extends Product {
    private double weight;
    
    public PhysicalProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}
