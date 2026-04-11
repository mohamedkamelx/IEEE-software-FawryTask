import java.util.LinkedHashMap;
import java.util.Map;

public class ShippingService {
    private static final double SHIPPING_FEE = 10.0; //per item 

    public static double getShippingFee(CartItem[] cart) {
        if (cart== null){
            return 0.0;
        }else{
            int items=0;
            for (int i=0;i<cart.length;i++){
                items+=cart[i].getQuantity();
            }
            return items*SHIPPING_FEE;
        }
    }

    public static void ship(CartItem[] cart) {
        if (cart.length==0) {
            return;
        }

        System.out.println("** Shipment notice **");

        double totalWeight = 0.0;

        for (CartItem item : cart) {
            PhysicalProduct prod = (PhysicalProduct) item.getProduct();
            int qty = item.getQuantity();
            String name = prod.getName();
            double unitWeight = prod.getWeight();

            double itemWeight = qty * unitWeight;
            totalWeight += itemWeight;

            System.out.println(qty + "x " + name + " " + formatWeight(itemWeight) );
        }

        System.out.println("Total package weight " + formatWeight(totalWeight));
    }

    private static String formatWeight(double weightInGram) {
        if (weightInGram < 1000) {
            return Math.round(weightInGram) + "g";
        } else {
            return Math.round(weightInGram * 10) / 10000.0 + "kg";
        }
    }

}