import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Mohamed", 1000);
        Cart cart = new Cart(customer);
        PhysicalProduct cheese = new ExpirableProduct("Cheese", 100, 10, LocalDate.of(2026, 12, 31), 200); 
        PhysicalProduct biscuits = new ExpirableProduct("Biscuits", 150, 5, LocalDate.of(2026, 12, 31), 700);
        NonPhysicalProd scratchCard = new NonPhysicalProd("Mobile Scratch Card", 50, 100);

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
