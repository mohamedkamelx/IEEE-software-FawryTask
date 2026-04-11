public class Cart {
    private Customer cust;
    private CartItem[] items;

    Cart(Customer c){this.cust=c;}

    public boolean isEmpty() {return items == null || items.length == 0;}
    public CartItem[] getItems(){return items;}

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (items== null){
            items = new CartItem[]{ new CartItem(product, quantity) };
        }
        for (int i =0;i<items.length;i++){
            if (items[i].getProduct().getID()==product.getID()){
                items[i].setQuantity(quantity+items[i].getQuantity());
                return;
            }
        }

        CartItem[] newItems = new CartItem[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }

        newItems[items.length] = new CartItem(product, quantity);

        items = newItems;
    }
}

