import java.time.LocalDate;

public class ExpirableProduct extends PhysicalProduct {
    private LocalDate expiryDate; // you must maintain the format of dd/mm/yy

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }


    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
