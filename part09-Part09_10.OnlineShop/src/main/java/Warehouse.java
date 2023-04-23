
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author tom
 */
public class Warehouse {
    
    private Map<String, Integer> stock;
    private Map<String, Integer> prices;
    
    public Warehouse() {
        this.stock = new HashMap<>();
        this.prices = new HashMap<>();
    }
    
    
    public void addProduct(String product, int price, int stock) {
        //check if product already on stock to update with the previous stock + the new one
        if (this.stock.containsKey(product)) {
            int newStock = this.stock.get(product) + stock;
            this.stock.put(product, newStock);
        } else {
            this.stock.put(product, stock);   //NO PRODUCT FOUND, ADD A NEW ONE
        }
        this.prices.put(product, price);      // ALWAYS ADD NEW PRICE
    }
    
    public int price(String product) {
        if (this.prices.containsKey(product)) {
            return this.prices.get(product);
        }
        return -99;                               // NO PRODUCT ON HASHMAP
    }
    
    public int stock(String product) {
        if (this.stock.containsKey(product)) {
            return stock.get(product);
        }
        return 0;                                // NO PRODUCT FOUND
    }
    
    public boolean take(String product) {
        if (stock.containsKey(product) && stock.get(product) > 0) {
            int remaining = stock.get(product) - 1;
            stock.put(product, remaining);
            return true;
        }
        return false;           // NO PRODUCT STOCK LEFT (or inexistent product)
    }
    
    public Set<String> products() {
        return stock.keySet();
    }
}
