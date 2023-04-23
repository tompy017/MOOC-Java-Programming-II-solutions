
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author tom
 */
public class ShoppingCart {
    
    private Map<String, Item> cart;
    
    
    public ShoppingCart() {
        this.cart = new HashMap<>();
    }
    
    
    public void add(String product, int price) {
        int oneUnit = 1;
        Item item = new Item(product, oneUnit, price);
        
        if (this.cart.containsKey(product)) {
            this.cart.get(product).increaseQuantity();
        
        } else {
            this.cart.put(product, item);
        }
    }
    
    public int price() {
        int totalCartPrice = 0;
        for (Item item : this.cart.values()) {
            totalCartPrice += item.price();
        }
        return totalCartPrice;
    }
    
    public void print() {
        for (Item item : this.cart.values()) {
            System.out.println(item);
        }
    }
    
}
