
/**
 *
 * @author tom
 */
public class Item {
    
    private String name;
    private int qty;
    private int unitPrice;

    public Item(String name, int qty, int unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    public int price() {
        return unitPrice * qty;
    }
    
    public void increaseQuantity() {
        this.qty ++;
    }
    
    
    @Override
    public String toString() {
        return name + ": " + qty;
    }
}
