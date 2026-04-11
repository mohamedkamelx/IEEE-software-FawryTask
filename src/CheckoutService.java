import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        CartItem[] cartItems = cart.getItems();
        CartItem[] shipment = new CartItem[]{};

        double subtotal = 0.0;

        for (CartItem item : cartItems) {
            Product p = item.getProduct();

            if (p.isExpired()) {
                throw new IllegalStateException(p.getName() + " is expired");
            }

            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalStateException(p.getName() + " is out of stock");
            }

            if (p.requiresShipping()){
                CartItem[] updatedShippment = new CartItem[shipment.length+1];
                for (int i=0;i<shipment.length;i++){
                    updatedShippment[i]=shipment[i];
                }
                updatedShippment[shipment.length]=item;
                shipment=updatedShippment;
            }
            subtotal += p.getPrice() * item.getQuantity();
        }

        double shipping = ShippingService.getShippingFee(shipment);

        double amount = subtotal + shipping;

        if (customer.getBalance() < amount) {
            throw new IllegalStateException("Customer's balance is insufficient");
        }

        ShippingService.ship(shipment);

        System.out.println("** Checkout receipt **");

        for (CartItem item : cartItems) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " +
                    Math.round(item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + Math.round(subtotal));
        System.out.println("Shipping " + Math.round(shipping));
        System.out.println("Amount " + Math.round(amount));

        for (CartItem item : cartItems) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }
        customer.pay(amount);
    }
}
